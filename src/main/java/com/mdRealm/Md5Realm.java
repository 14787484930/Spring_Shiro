package com.mdRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxl
 * @date 2019/9/6 11:54
 * @describe
 */
public class Md5Realm extends AuthorizingRealm {

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String userName = (String)principals.getPrimaryPrincipal();
        System.out.println("realm中获取的用户名："+userName);

        //通过用户名获取权限
        String[] roles = {"role1","role2"};

        //权限列表
        List<String> perms = new ArrayList<String>();

        for(String perm : roles){
            perms.add("user:create");
            perms.add("user:update");
        }


        return null;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //通过token对象获取用户名
        String userName = token.getPrincipal().toString();
        //通过用户名获取密码（加密后的密码值）
        String passsword = "0659c7992e268962384eb17fafe88364";
        //加密用的盐值
        String salt = "abc";

        //判断账号是否存在
        if(passsword == null || passsword.equals("")){

            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,passsword,ByteSource.Util.bytes(salt),"myMd5Realm");
        return simpleAuthenticationInfo;
    }
}
