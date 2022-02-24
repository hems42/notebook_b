package com.notebook_b.org.product.security.jwt_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private  JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public void configurePasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {

        builder.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http.cors()
            .and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/api/authentication/login","/api/authentication/signup","/api/authentication/logout").permitAll()
                .anyRequest().authenticated()
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);


    }
}