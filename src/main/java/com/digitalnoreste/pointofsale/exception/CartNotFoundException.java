package com.digitalnoreste.pointofsale.exception;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(Integer cartId) {
        super(String.format("Could not find cart with id %d", cartId));
    }
}
