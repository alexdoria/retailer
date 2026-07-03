package com.digitalnoreste.pointofsale.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String username;
    private String role;
}
