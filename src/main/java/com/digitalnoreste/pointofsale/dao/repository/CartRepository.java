package com.digitalnoreste.pointofsale.dao.repository;

import com.digitalnoreste.pointofsale.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
