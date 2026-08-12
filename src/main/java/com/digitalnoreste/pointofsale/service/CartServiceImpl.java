package com.digitalnoreste.pointofsale.service;

import com.digitalnoreste.pointofsale.dao.repository.CartRepository;
import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.dto.request.CustomerRequest;
import com.digitalnoreste.pointofsale.dto.request.ProductRequest;
import com.digitalnoreste.pointofsale.dto.response.CartResponse;
import com.digitalnoreste.pointofsale.dto.response.CustomerResponse;
import com.digitalnoreste.pointofsale.dto.response.ProductResponse;
import com.digitalnoreste.pointofsale.entities.Cart;
import com.digitalnoreste.pointofsale.entities.Customer;
import com.digitalnoreste.pointofsale.entities.Product;
import com.digitalnoreste.pointofsale.exception.CartNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;
  private static final String FRONTDESK_CUSTOMER_NAME = "frontDesk";

  public CartServiceImpl(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public CartResponse createCart(CartRequest cartRequest) {
    Cart cartToSave = toEntity(cartRequest);
    // Save cart to database
    Cart saved = cartRepository.save(cartToSave);
    log.info("Saving Cart with ID: {} to the database. Amount: {}, Customer: {}. Product count: {}",
        saved.getId(),
        saved.getAmount(),
        saved.getBuyer().getUsername(),
        saved.getCartProducts().size());
    return toResponse(saved);

  }

  @Override
  public List<CartResponse> getAllCarts() {
    log.info("Fetching all Carts....");
    return cartRepository.findAll().stream().map(
        t -> toResponse(t)).collect(Collectors.toList());
  }

  @Override
  public CartResponse updateCart(CartRequest cartRequest, Integer cartId) {
    log.info("Updating Cart with ID: {} in the database. New Amount: {}, Customer: {}. Product count: {}", cartId,
        cartRequest.getAmount(), cartRequest.getBuyer().getUsername(), cartRequest.getCartProducts().size());
    Cart cartToUpdate = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
    cartToUpdate.setAmount(cartRequest.getAmount());
    cartToUpdate.setBuyer(toEntity(cartRequest.getBuyer()));
    cartToUpdate.setCartProducts(toEntity(cartRequest.getCartProducts()));
    Cart saved = cartRepository.save(cartToUpdate);
    return toResponse(saved);
  }

  @Override
  public void deleteCart(Integer cartId) {
    log.info("Deleting Cart with ID: {} from the database.", cartId);
    cartRepository.deleteById(cartId);
  }

  private CartResponse toResponse(Cart cart) {
    CartResponse cartResponse = new CartResponse();
    cartResponse.setId(cart.getId());
    cartResponse.setCartProducts(
        toResponse(cart.getCartProducts()));
    cartResponse.setCreatedAt(cart.getCreated());
    cartResponse.setAmount(cart.getAmount());
    cartResponse.setBuyer(toResponse(cart.getBuyer()));
    return cartResponse;
  }

  private Set<ProductResponse> toResponse(Set<Product> products) {
    return products.stream().map(t -> toResponse(t)).collect(Collectors.toSet());
  }

  private CustomerResponse toResponse(Customer customer) {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setId(customer.getId());
    customerResponse.setUsername(customer.getUsername());
    customerResponse.setRole(customer.getRole());
    return customerResponse;
  }

  private ProductResponse toResponse(Product product) {
    ProductResponse productResponse = new ProductResponse();
    productResponse.setId(product.getId());
    productResponse.setName(product.getName());
    productResponse.setDescription(product.getDescription());
    productResponse.setPriceBuy(product.getPriceBuy());
    productResponse.setPriceSell(product.getPriceSell());
    productResponse.setInventory(product.getInventory());
    productResponse.setUnit(product.getUnit());
    productResponse.setCreatedAt(product.getCreatedAt());
    return productResponse;
  }

  private Cart toEntity(CartRequest cartRequest) {
    Cart cart = new Cart();
    cart.setCartProducts(toEntity(cartRequest.getCartProducts()));
    cart.setAmount(cartRequest.getAmount() == null ? BigDecimal.ZERO : cartRequest.getAmount());
    cart.setCreated(LocalDateTime.now());
    cart.setBuyer(toEntity(cartRequest.getBuyer()));
    return cart;
  }

  private Set<Product> toEntity(Set<ProductRequest> productsRequests) {
    if (productsRequests == null)
      return new HashSet<>();
    return productsRequests.stream().map(this::toEntity).collect(Collectors.toSet());

  }

  private Product toEntity(ProductRequest productRequest) {
    Product product = new Product();
    product.setName(productRequest.getName());
    product.setDescription(productRequest.getDescription());
    product.setPriceBuy(productRequest.getPriceBuy());
    product.setPriceSell(productRequest.getPriceSell());
    product.setUnit(productRequest.getUnit());
    product.setInventory(productRequest.getInventory());
    return product;
  }

  private Customer toEntity(CustomerRequest customerRequest) {
    if (customerRequest == null || customerRequest.getUsername() == null) {
      Customer customer = new Customer();
      log.info("No customer name set, setting to: {}", FRONTDESK_CUSTOMER_NAME);
      customer.setUsername(FRONTDESK_CUSTOMER_NAME);
      return customer;
    }
    return new Customer(customerRequest.getUsername());
  }

}
