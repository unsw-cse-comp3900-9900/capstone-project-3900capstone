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
        registry.addViewController("/singleListing.html").setViewName("singleListing");
        registry.addViewController("/unauth.html").setViewName("unauth");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/contact.html").setViewName("contact");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/confirmation.html").setViewName("confirmation");
        registry.addViewController("/listings.html").setViewName("listings");
        registry.addViewController("/addBook.html").setViewName("addBook");
        registry.addViewController("/removeBook.html").setViewName("removeBook");
        registry.addViewController("/cart.html").setViewName("cart");
        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/updateBook.html").setViewName("updateBook");
        registry.addViewController("/modify.html").setViewName("modifyBook");
        registry.addViewController("/add.html").setViewName("add");
        registry.addViewController("/delete.html").setViewName("delete");
        registry.addViewController("/payment.html").setViewName("payment");
        registry.addViewController("/analytics.html").setViewName("analytics");
        registry.addViewController("/changePwd.html").setViewName("changePwd");
        registry.addViewController("/profile.html").setViewName("profile");
        registry.addViewController("/feedback.html").setViewName("feedback");
    }


}



