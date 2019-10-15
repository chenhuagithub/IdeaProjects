package com.atguigu.shiroproject.utils;


import com.atguigu.shiroproject.bean.User;
import com.atguigu.shiroproject.dao.UserMapper;
import com.atguigu.shiroproject.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        // 给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 到达数据库查询当前登录用户的授权字符串
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

//        userMapper.selectOne(new QueryWrapper<User>().)

        // 添加资源的授权字符串
        info.addStringPermission(user.getPerms());
        return info;
    }


    @Autowired
    private UserService userService;

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.findUser(token.getUsername());
        if(user == null){
            return null;
        }
//        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
//        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), credentialsSalt, getName());
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
