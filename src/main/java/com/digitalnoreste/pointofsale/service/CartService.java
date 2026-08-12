package com.digitalnoreste.pointofsale.service;

import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.dto.response.CartResponse;

import java.util.List;

public interface CartService {
  CartResponse createCart(CartRequest cartRequest);

  List<CartResponse> getAllCarts();

  // Delete cart method
  void deleteCart(Integer cartId);

  // Update cart method
  CartResponse updateCart(CartRequest cartRequest, Integer cartId);
}
