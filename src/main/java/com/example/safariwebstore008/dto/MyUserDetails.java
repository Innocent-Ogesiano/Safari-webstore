package com.example.safariwebstore008.dto;

import com.example.safariwebstore008.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean isEnabled;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user){
        this.userName = user.getEmail();
        this.password = user.getPassword();
        this.isEnabled = user.getIsEnabled();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String userAuthority : user.getRoles().toString().split(",")) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userAuthority);
            authorities.add(simpleGrantedAuthority);
        }
        this.authorities = authorities;
    }

    public MyUserDetails() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return isEnabled;
    }
}
