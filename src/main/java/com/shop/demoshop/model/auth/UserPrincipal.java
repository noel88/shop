package com.shop.demoshop.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.demoshop.model.user.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Setter @Getter
public class UserPrincipal implements UserDetails {

    private Long id;

    private String userId;

    @JsonIgnore
    private String password;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String phoneNum;

    @JsonIgnore
    private String zipCode;

    @JsonIgnore
    private String Addr;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserPrincipal(
                user.getId(),
                user.getUserId(),
                user.getPassword(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNum(),
                user.getZipCode(),
                user.getAddr(),
                authorities
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
