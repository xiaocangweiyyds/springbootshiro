package com.yr.config.shiro.realm;

import com.yr.entity.UUser;
import com.yr.service.IUPermissionService;
import com.yr.service.IUUserService;
import com.yr.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(loginService.queryRolesByName(username));
        simpleAuthorizationInfo.addStringPermissions(loginService.queryPermissionsByName(username));

        return simpleAuthorizationInfo;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = authenticationToken.getPrincipal().toString();
        UUser uUser = loginService.login(principal);
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        if (uUser != null) {
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, uUser.getPswd(), new Md5Hash(uUser.getEmail()), getName());
        } else {
            System.out.println("账号或密码错误");
        }
        return simpleAuthenticationInfo;
    }


}
