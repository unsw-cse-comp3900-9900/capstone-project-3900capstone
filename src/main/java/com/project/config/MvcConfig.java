package com.project.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/signup.html").setViewName("signup");
        //registry.addViewController("/listings.html").setViewName("listings");
        registry.addViewController("/blog.html").setViewName("blog");
        registry.addViewController("/singleBlog.html").setViewName("singleBlog");
        registry.addViewController("/elements.html").setViewName("elements");
        registry.addViewController("/singleList.html").setViewName("singleList");
        registry.addViewController("/unauth.html").setViewName("unauth");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/contact.html").setViewName("contact");
        registry.addViewController("/main.html").setViewName("main");
        //registry.addViewController("/lists").setViewName("listings");
        registry.addViewController("/confirmation.html").setViewName("confirmation");
    }


}



