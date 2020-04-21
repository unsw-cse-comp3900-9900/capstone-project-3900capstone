package com.project.config;


import com.project.pojo.Users;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();

        Users currentUser = (Users) subject.getPrincipal();

        info.addStringPermission(currentUser.getAuth());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        Users user1 = userService.queryUsersByEmail(userToken.getUsername());


        if (user1 == null){
            return null;
        }


        return new SimpleAuthenticationInfo(user1, user1.getUserPwd() ,"");
    }
}
