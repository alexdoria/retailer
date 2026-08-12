package com.digitalnoreste.pointofsale.controller;

import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.dto.response.CartResponse;
import com.digitalnoreste.pointofsale.service.CartService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @PostMapping("/")
  public CartResponse createCart(@Valid @RequestBody CartRequest cartRequest) {
    log.info("Cart request received: {}", cartRequest);
    return cartService.createCart(cartRequest);
  }

  @GetMapping("/")
  public List<CartResponse> allCarts() {
    return cartService.getAllCarts();
  }

  @PutMapping("/{id}")
  public CartResponse updateSale(@Valid @RequestBody CartRequest cartRequest, @PathVariable Integer id) {
    log.info("Update Cart request recieced: {}", id);
    return cartService.updateCart(cartRequest, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
    log.info("Delete Cart request received: {}", id);
    cartService.deleteCart(id);
    return ResponseEntity.noContent().build();
  }
}
