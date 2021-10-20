package com.nvv.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("artem").password("555").roles("XR"))
                .withUser(userBuilder.username("artem2").password("555").roles("XY"))
                .withUser(userBuilder.username("artem3").password("555").roles("XR","XY"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/").hasAnyRole("XR","XY").antMatchers("/hr_info").hasAnyRole("XR")
                .antMatchers("/manager_info").hasAnyRole("XY").and().formLogin().permitAll();
    }
}
