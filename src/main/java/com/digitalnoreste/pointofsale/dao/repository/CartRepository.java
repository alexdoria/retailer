package com.digitalnoreste.pointofsale.dao.repository;

import com.digitalnoreste.pointofsale.entities.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
