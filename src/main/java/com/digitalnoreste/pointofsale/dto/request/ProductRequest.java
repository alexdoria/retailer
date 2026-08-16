package com.digitalnoreste.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal priceBuy;
    private BigDecimal priceSell;
    private BigDecimal inventory;
    private String unit;
}
