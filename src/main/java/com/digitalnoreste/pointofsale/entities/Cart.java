package com.digitalnoreste.pointofsale.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART")
public class Cart implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer Id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_items", referencedColumnName = "id")
    private Set<Product> cartProducts = new HashSet<>();

    @Column
    private LocalDateTime created;

    @Column
    private BigDecimal amount;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer buyer;

}
