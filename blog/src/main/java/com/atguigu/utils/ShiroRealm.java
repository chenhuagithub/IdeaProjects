package com.atguigu.utils;

import com.atguigu.bean.Blogger;
import com.atguigu.dao.BloggerMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    BloggerMapper bloggerMapper;

    // 用于授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("[授权] doGetAuthorizationInfo----->"+principalCollection);

        // 1. 从PricipalConllection中获取登录用户信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        // 2. 利用登录的用户的信息来获取但前用户的角色或权限(可以需要查询数据库)
        Set<String> roles = new HashSet<>();

        // 给登录的用户授权
        roles.add(primaryPrincipal.toString());

//        roles.add("user");
//        if("admin".equals(primaryPrincipal)){
//            roles.add("admin");
//        }
        // 3. 创建SimpleAuthorizationInfo, 并设置roles属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        // 4. 返回 SimpleAuthorizationInfo 对象
        return info;
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


    // 用于验证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("doGetAuthorizationInfo----->"+authenticationToken.hashCode());
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;

        String username = upToken.getUsername();

        System.out.println("从数据库中获取username:--->"+username+"所对应的信息");

        // 从数据库中查询用户
        Blogger blogger = bloggerMapper.selectBlogger(username);

        //判断用户是否存在
        if(blogger == null){
            throw  new UnknownAccountException("用户不存在");
        }

//        if("unknown".equals(username)){
//            throw new UnknownAccountException("用户不存在");
//        }


//        if("monster".equals(username)){
//            throw new LockedAccountException("用户被锁定");
//        }

        // 以下信息是从数据库中获取的


        // principal: 认证的实体信息, 可以是usernmae, 也可以是数据表对应用户的实体类对象
        Object principal = username;
        //credentials: 密码
        Object credentials = blogger.getPassword();
        System.out.println("credentials--->"+credentials);
//        if("admin".equals(username)){
//            credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
//        }
//        if("user".equals(username)){
//            credentials = "098d2c478e9c11555ce2823231e02ec1";
//        }

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
