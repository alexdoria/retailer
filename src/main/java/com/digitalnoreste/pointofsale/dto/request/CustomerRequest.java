package com.digitalnoreste.pointofsale.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
public class CustomerRequest {
    private String username;

    public CustomerRequest() {}

    public CustomerRequest(String username) {
        this.username = username;
    }


}
