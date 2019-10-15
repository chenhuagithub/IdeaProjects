package com.atguigu.logindemo.config;

import com.atguigu.logindemo.bean.Authorization;
import com.atguigu.logindemo.bean.User;
import com.atguigu.logindemo.dao.AuthorizationMapper;
import com.atguigu.logindemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizationMapper authorizationMapper;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        // 查询数据库获取权限
        Authorization perms = authorizationMapper.findPerms(user.getUsername());
        String role = perms.getPermissions().getRole();
        info.addStringPermission(role);
        return info;
    }


    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        User user = userService.findByUsername(token.getUsername());
        if(user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
