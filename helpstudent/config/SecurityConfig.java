package com.example.helpstudent.config;

import com.example.helpstudent.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

private final MyUserDetailsService myUserDetailsService;
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                        //.antMatchers("api/v1/auth/register/**","/api/v1/auth","api/v1/order/**").permitAll()
                .antMatchers("/api/v1/auth/register").permitAll()
                        .antMatchers(HttpMethod.POST,"/api/v1/expert/expert").hasAuthority("expert")
                        .anyRequest().authenticated()
                        .and()
                        .httpBasic();



    }

}
