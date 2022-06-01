//package com.notebook_b.org.product.security.jwt_security;
//
//import com.notebook_b.org.entity.leadRole.User;
//import com.notebook_b.org.repository.UserDao;
//import com.sun.security.auth.UserPrincipal;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static org.springframework.security.config.Elements.JWT;
//
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//    private UserDao userRepository;
//
//    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserDao userRepository) {
//        super(authenticationManager);
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // Read the Authorization header, where the JWT token should be
//        String header = request.getHeader(JwtProperties.HEADER_STRING);
//
//        // If header does not contain BEARER or is null delegate to Spring impl and exit
//        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // If header is present, try grab user principal from database and perform authorization
//        Authentication authentication = getUsernamePasswordAuthentication(request);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Continue filter execution
//        chain.doFilter(request, response);
//    }
//
//    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(JwtProperties.HEADER_STRING)
//                .replace(JwtProperties.TOKEN_PREFIX, "");
//
//        if (token != null) {
//            // parse the token and validate it
//            String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
//                    .build()
//                    .verify(token)
//                    .getSubject();
//
//            // Search in the DB if we find the user by token subject (username)
//            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
//            if (userName != null) {
//                User user = userRepository.getUserByNickName(userName);
//                UserPrincipal principal = new UserPrincipal(user);
//                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
//                return auth;
//            }
//            return null;
//        }
//        return null;
//    }
//}