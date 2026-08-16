package com.digitalnoreste.pointofsale.service;

import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.dto.request.CustomerRequest;
import com.digitalnoreste.pointofsale.dto.request.ProductRequest;
import com.digitalnoreste.pointofsale.dto.response.CartResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

class CartServiceImplTest {
    @Autowired
    CartService cartService;

    @Test
    void createCartTest() {
        //Arrange
        Set<ProductRequest> setOfProductsRequests = new HashSet<>();
        setOfProductsRequests.add(new ProductRequest("product1", "Some Product",BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, "KG"));
        setOfProductsRequests.add(new ProductRequest("product2", "Some Product",BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, "KG"));


        CartRequest cartRequest = CartRequest.builder()
                .amount(BigDecimal.valueOf(791.50))
                .buyer(new CustomerRequest("testUsername"))
                .cartProducts(setOfProductsRequests)
                .build();

        //Act
        CartResponse cart = cartService.createCart(cartRequest);

        //Assert that the cart is saved
        Assertions.assertNotNull(cart);

    }

    @Test
    void getAllCarts() {
    }

    @Test
    void updateCart() {
    }

    @Test
    void deleteCart() {
    }
}