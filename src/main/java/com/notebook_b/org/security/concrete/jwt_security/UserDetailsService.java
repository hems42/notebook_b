package com.notebook_b.org.security.concrete.jwt_security;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

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
            return new User(user.getNickName(),user.getPassword(),new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }


}