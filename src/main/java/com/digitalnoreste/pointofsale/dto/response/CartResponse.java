package com.digitalnoreste.pointofsale.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class CartResponse {
  private Integer id;
  private Set<ProductResponse> cartProducts;
  private LocalDateTime createdAt;
  private BigDecimal amount;
  private CustomerResponse buyer;

}
