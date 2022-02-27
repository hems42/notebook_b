package com.notebook_b.org.product.security.jwt_security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.notebook_b.org.product.appConstants.AppConstants.*;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenManager jwtTokenManager;

    public JwtAuthenticationFilter(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = httpServletRequest.getHeader(AUTH_HEADER);

        String userNickName = null;
        String accessToken = null;

        if (authHeader != null && authHeader.contains(TOKEN_START_WITH)) {
            accessToken = authHeader.substring(TOKEN_START_WITH.length());
            try {
                userNickName = jwtTokenManager.getUserNameFromToken(accessToken);
            } catch (Exception e) {
            }
        }

        if (userNickName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtTokenManager.validateToken(accessToken)) {
                UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userNickName, null, new ArrayList<>());
                userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);

                log.info("token authenticated");
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}