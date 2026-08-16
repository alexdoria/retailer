package com.digitalnoreste.pointofsale.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class CartRequest implements Serializable {

    @NotNull
    @DecimalMin("0.01")
    private final BigDecimal amount;

    private final CustomerRequest buyer;

    @NotEmpty
    private Set<ProductRequest> cartProducts = new HashSet<>();

}

