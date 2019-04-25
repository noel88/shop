package com.shop.demoshop.controller;

import com.shop.demoshop.exception.AppException;
import com.shop.demoshop.model.api.response.JwtAuthenticationResponse;
import com.shop.demoshop.model.api.request.SigninRequest;
import com.shop.demoshop.model.api.request.SignupRequest;
import com.shop.demoshop.model.user.Role;
import com.shop.demoshop.model.user.RoleName;
import com.shop.demoshop.model.user.User;
import com.shop.demoshop.repository.RoleRepository;
import com.shop.demoshop.repository.UserRepository;
import com.shop.demoshop.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    public AuthRestController(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        User user = User.builder()
                .userId(signupRequest.getUserId())
                .password(signupRequest.getPassword())
                .username(signupRequest.getUsername())
                .phoneNum(signupRequest.getPhoneNum())
                .email(signupRequest.getEmail())
                .zipCode(signupRequest.getZipCode())
                .addr(signupRequest.getAddr())
                .build();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User Role not set"));
        user.setRole(Collections.singleton(userRole));
        userRepository.save(user);

        return ResponseEntity.ok("success");
    }

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@Valid @RequestBody SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       signinRequest.getUserId(),
                       signinRequest.getPassword()
               )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

}
