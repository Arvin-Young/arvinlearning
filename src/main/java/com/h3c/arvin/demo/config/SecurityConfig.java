package com.h3c.arvin.demo.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests(req -> req.antMatchers("/hello/test").hasRole("ADMIN"));
        http.formLogin(Customizer.withDefaults())
                .authorizeRequests(req -> req.antMatchers("/hello/test").authenticated());
    }
}
