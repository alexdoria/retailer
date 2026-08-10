package com.digitalnoreste.pointofsale.service;

import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.dto.response.CartResponse;

import java.util.List;

public interface CartService {
  CartResponse createSale(CartRequest cartRequest);

  List<CartResponse> getAllCarts();

  // Delete cart method
  void deleteSale(Integer cartId);

  // Update cart method
  CartResponse updateSale(CartRequest cartRequest, Integer cartId);
}
