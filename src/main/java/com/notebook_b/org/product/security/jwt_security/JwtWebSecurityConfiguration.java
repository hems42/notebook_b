package com.notebook_b.org.product.security.jwt_security;

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
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class JwtWebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final UserDetailsService userDetailsService;

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final JwtAccessDeniedFilter  jwtAccessDeniedFilter;

    public JwtWebSecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
                                       UserDetailsService userDetailsService,
                                       JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                                       JwtAccessDeniedFilter jwtAccessDeniedFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedFilter = jwtAccessDeniedFilter;
        jwtAuthenticationFilter.setJwtUserDetailsService(userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());
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
                .authorizeRequests().antMatchers("/api/authentication/**").permitAll()
                      //  .and().authorizeRequests().antMatchers("/api/users/dene_user")
                       // .hasRole("USER")
                        //.and().authorizeRequests().antMatchers("/api/users/dene_admin")
                       // .hasRole("ADMIN")

            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
                        .exceptionHandling().accessDeniedHandler(jwtAccessDeniedFilter)
                        .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);



    }
}