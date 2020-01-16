package com.lks.demo.core;

import com.lks.demo.entity.User;
import com.lks.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


/**
 * shrio的指定方法
 * @author lks
 */
public class ShiroRelam extends AuthorizingRealm {

    private UserService userService;


    @Autowired
    public ShiroRelam(UserService userService) {
        this.userService = userService;
    }

    /**
     * 授权
     *
     * @param principalCollection 入参
     * @return 授权对象
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new AuthorizationException("获取文件为空");
        }
        //查询获取和设置文件中的数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permisses = new HashSet<>();
        User userInfo = userService.getUserInfo();
        //是否要判断用户是否存在
        if (userInfo != null) {
            permisses = userInfo.getPermisstions();
        }
        info.setStringPermissions(permisses);
        return info;
    }

    /**
     * 认证
     *
     * @param token token值
     * @return 认证对象
     * @throws AuthenticationException 无权限异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        info.setCredentials(null);
        return info;
    }
}
