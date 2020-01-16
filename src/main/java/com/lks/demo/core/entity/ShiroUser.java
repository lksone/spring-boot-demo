package com.lks.demo.core.entity;

import java.util.Set;

/**
 * 登录用户实体类
 */
public class ShiroUser {

    private String username;

    private Set<String> permissions;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
