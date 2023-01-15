package com.org.leetstats.models.auth;

import com.org.leetstats.entities.auth.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private final String username;
    private final String password;
    private final boolean isLocked;
    private final List<GrantedAuthority> authorities = new ArrayList<>();

   public CustomUserDetail(String username, String password, boolean isLocked, List<Role> authorities){
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
        authorities.forEach((role) -> this.authorities.add(new SimpleGrantedAuthority(role.getName())));

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
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
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
