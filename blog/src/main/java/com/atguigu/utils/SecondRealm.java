package com.atguigu.utils;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class SecondRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     *  1. 把AuthenticationToken 转换为UsernamePasswordToken
     *
     *  2. UsernamePasswordToken 中获取username
     *
     *  3. 调用数据库的方法, 从数据库中查询username对应的用户记录
     *
     *  4. 若用户不存在, 则可以抛出UnknownAccountException 异常
     *
     *  5. 根据用户信息的情况, 决定是否需要抛出其他的把AuthenticationException 异常
     *
     *  6. 根据用户情况来构建
     *
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("[FirstRealm] doGetAuthorizationInfo----->");


        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;

        String username = upToken.getUsername();

        System.out.println("从数据库中获取username:"+username+"所对应的信息");

        if("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }


        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        // 以下信息是从数据库中获取的

        // principal: 认证的实体信息, 可以是usernmae, 也可以是数据表对应用户的实体类对象
        Object principal = username;
        //credentials: 密码
        Object credentials = null;
        if("admin".equals(username)){
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        }
        if("user".equals(username)){
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
        }

        //realmName: 当前realm对象的name, 调用弗雷的getName()方法即可
        String realmName = getName();
        System.out.println("realmName--->"+realmName);
        //设置加密盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);


        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);

        return info;
    }

}
