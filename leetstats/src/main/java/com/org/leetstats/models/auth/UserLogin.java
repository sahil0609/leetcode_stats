package com.org.leetstats.models.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogin {
    private final String email;

    private final String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    UserLogin(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName(){return name;}
}
