package com.notebook_b.org.security.jwt_security;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;



    @PostConstruct
    public void init() {


    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DataResult result =userService.getUserByNickName(username);

        UserDto user=result !=null ? (UserDto) result.getData() :null ;

        if (user!=null) {
            return new JwtUserDetail((com.notebook_b.org.entity.User) result.getData());
        }


        throw new UsernameNotFoundException(username);
    }


}