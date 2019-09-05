package com.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //通过token获取用户名
        String userName = (String)token.getPrincipal();

        //根据用户名从数据看获取该用户名的密码‘
        String password = "123";

        //账号不存在时返回空
        if(password == null || password.equals("")){
            return null;
        }

        //账号存在时将查询出的数据封装进行返回
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,"myrealm");

        return authenticationInfo;
    }
}
