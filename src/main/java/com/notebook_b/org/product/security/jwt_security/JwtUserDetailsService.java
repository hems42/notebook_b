package com.notebook_b.org.product.security.jwt_security;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.product.dto_convertor.principal_convertor.UserDtoConvertor;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    private final UserDtoConvertor userDtoConvertor;

    public JwtUserDetailsService(IUserService userService, UserDtoConvertor userDtoConvertor) {
        this.userService = userService;
        this.userDtoConvertor = userDtoConvertor;
    }


    @PostConstruct
    public void init() {


    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DataResult result =userService.getUserByNickName(username);

        UserDto userDto=result !=null ? (UserDto) result.getData() :null ;

        if (userDto!=null) {

            User user =userDtoConvertor.convert(userDto);

            return new JwtUserDetail(user); }

        throw new UsernameNotFoundException(username);
    }


}