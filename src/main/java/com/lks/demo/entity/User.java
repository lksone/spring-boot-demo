package com.lks.demo.entity;


import lombok.Data;

import java.util.Set;

public class User {

    private Long id;

    private String username;

    private String password;

    Set<String> permisstions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getPermisstions() {
        return permisstions;
    }

    public void setPermisstions(Set<String> permisstions) {
        this.permisstions = permisstions;
    }
}
