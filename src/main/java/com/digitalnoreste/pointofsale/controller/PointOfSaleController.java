package com.digitalnoreste.pointofsale.controller;

import com.digitalnoreste.pointofsale.dto.response.CartResponse;
import com.digitalnoreste.pointofsale.dto.request.CartRequest;
import com.digitalnoreste.pointofsale.service.CartService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PointOfSaleController {

    private final CartService cartService;

    public PointOfSaleController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String testGetEndpoint() {

        log.info("Requested Liveliness check.");
        return "Successful GET to DN Point of Sale";
    }

    // Cart controller receives a Cart request
    @PostMapping("/cart")
    public CartResponse createSale(@Valid @RequestBody CartRequest cartRequest) {
        log.info("Received Cart request: {}", cartRequest);
        return cartService.createSale(cartRequest);
    }

    @PutMapping("/cart/{id}")
    public CartResponse updateSale(@Valid @RequestBody CartRequest cartRequest, @PathVariable Integer id) {
        log.info("Updating Cart request: {}", id);
        return cartService.updateSale(cartRequest, id);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        log.info("Deleting Cart request: {}", id);
        cartService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
