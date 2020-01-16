package com.lks.demo.core.entity;

/**
 * likesheng
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

    public UsernamePasswordToken() {
        super();
    }

    public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
}
