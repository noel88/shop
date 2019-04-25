package com.shop.demoshop.model.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SigninRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

}
