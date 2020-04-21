package com.project.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        /*
            anon: 无需认证
            authc: 必须认证
            user: 记住我才能用
            perms 有某个资源
            role 有某个角色权限
         */

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/","anon");
        filterMap.put("/index.html","anon");
        filterMap.put("/singleListing.html","authc,perms[users:normal]");
        filterMap.put("/blog.html","authc");
        filterMap.put("/singleBlog.html","authc");
        filterMap.put("/elements.html","authc");
        filterMap.put("/logout","logout");
        filterMap.put("/main.html","authc");
        filterMap.put("/add.html","authc,perms[users:admin]");
        filterMap.put("/addBook.html","authc,perms[users:admin]");
        filterMap.put("/analytics.html","authc,perms[users:admin]");
        filterMap.put("/cart.html","authc,perms[users:normal]");
        filterMap.put("/changePwd.html","authc");
        filterMap.put("/confirmation.html","authc,perms[users:normal]");
        filterMap.put("/contact.html","authc,perms[users:normal]");
        filterMap.put("/delete.html","authc,perms[users:admin]");
        filterMap.put("/feedback.html","authc,perms[users:normal]");
        filterMap.put("/modify.html","authc,perms[users:admin]");
        filterMap.put("/payment.html","authc,perms[users:normal]");
        filterMap.put("/profile.html","authc");
        filterMap.put("/removeBook.html","authc,perms[users:admin]");
        filterMap.put("/updateBook.html","authc,perms[users:admin]");
        filterMap.put("/listings.html","authc,perms[users:normal]");





        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/loginPage");


        bean.setUnauthorizedUrl("/unauth");

        return bean;
    }


    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //Create object realm
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
