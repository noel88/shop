package com.shop.demoshop.model.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter @Getter
public class SignupRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    private String phoneNum;

    private String zipCode;

    private String addr;

}
