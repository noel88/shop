package com.shop.demoshop.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop/auth")
public class AuthController {

    @GetMapping("/signin")
    public String signinView() {
        return "/auth/signinView";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "/auth/signupView";
    }

}
