package com.digitalnoreste.pointofsale.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal priceBuy;
    private BigDecimal priceSell;
    private BigDecimal inventory;
    private String unit;
    private LocalDateTime createdAt;

}
