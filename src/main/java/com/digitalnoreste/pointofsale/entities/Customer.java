package com.digitalnoreste.pointofsale.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long Id;

  @Column
  private String username;

  @Column
  private String role;

  @Column
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "buyer")
  private Set<Cart> carts = new HashSet<>();

  public Customer(String name) {
    this.username = name;
  }

}
