package com.notebook_b.org.product.security.jwt_security;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.product.dto_convertor.entity_convertor.UserDtoConvertor;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.entity.User;
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

    @Autowired
    private UserDtoConvertor userDtoConvertor;



    @PostConstruct
    public void init() {


    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DataResult result =userService.getUserByNickName(username);

        UserDto userDto=result !=null ? (UserDto) result.getData() :null ;
        User user =userDtoConvertor.convert(userDto);

        if (user!=null) {
            return new JwtUserDetail(user);
        }

        throw new UsernameNotFoundException(username);
    }


}