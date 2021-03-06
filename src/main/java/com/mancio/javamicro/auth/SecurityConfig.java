/*package com.mancio.JavaMicro.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                .antMatchers("/", "/login**","/callback/", "/webjars/**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated();
                //.and()
                //.httpBasic();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login**","/callback/", "/error**",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        //"/swagger-ui.html",
                        "/webjars/**" ,
                        "/swagger.json")
                .permitAll()
                .anyRequest().authenticated();



    }
}*/
