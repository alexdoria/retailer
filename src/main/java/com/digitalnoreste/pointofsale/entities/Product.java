package com.digitalnoreste.pointofsale.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE_BUY")
    private BigDecimal priceBuy;

    @Column(name = "PRICE_SELL")
    private BigDecimal priceSell;

    @Column(name = "INVENTORY")
    private BigDecimal inventory;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public String toString(){
        return name;
    }

}
