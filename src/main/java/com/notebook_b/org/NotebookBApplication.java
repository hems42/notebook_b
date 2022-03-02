package com.notebook_b.org;

import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import com.notebook_b.org.entity.security.RefreshToken;
import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.repository.UserDao;
import com.notebook_b.org.service.concrete.ConfirmationTokenService;
import com.notebook_b.org.service.concrete.RefreshTokenService;
import com.notebook_b.org.service.concrete.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootApplication
@EnableSwagger2
public class NotebookBApplication implements CommandLineRunner {

    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @Autowired
    UserService userService;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao  userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    RefreshTokenService refreshTokenService;

    public static void main(String[] args) {

        SpringApplication.run(NotebookBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {




    /*      User user = userDao.getUserByNickName("hasan");
//
//       RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
//
//     RefreshToken refreshTokenSaved =  refreshTokenService.saveRefreshToken(refreshToken).get();

        RefreshToken refreshTokenFound1 =refreshTokenService.getRefreshTokenByToken("88710130-f368-4a38-8cd9-dc1069d9a355").get();

        RefreshToken refreshTokenFound2 = refreshTokenService.getRefreshTokenByUser(user).get();



        try {
            refreshTokenService.verifyRefreshToken(refreshTokenFound1);
        }
        catch (BaseExceptionModel e)
        {
            System.out.println("errorCode : "+e.getErrorCode());

            System.out.println("errorMessage : "+e.getErrorMessage());

            System.out.println("errorDescription : "+e.getErrorDescription());
        }

        refreshTokenService.deleteRefreshToken(user);*/

    /*

       User user = userDao.getUserByNickName("hasan");
//
//        ConfirmationToken confirmationToken = confirmationTokenService.createConfirmationToken(user);
//
//        confirmationTokenService.saveConfirmationToken(confirmationToken);

      ConfirmationToken foundToken_1 =  confirmationTokenService.getConfirmationToken(user).get();

        ConfirmationToken foundToken_2 = confirmationTokenService.getConfirmationToken("8a2d881e-758b-47c0-80bf-5b990ab8fafe").get();

        try {

            Boolean verifyResult =  confirmationTokenService.verifyConfirmationToken("8a2d881e-758b-47c0-80bf-5b990ab8fafe");

        }
        catch (BaseExceptionModel e)
        {
            System.out.println("errorCode : "+e.getErrorCode());

            System.out.println("errorMessage : "+e.getErrorMessage());

            System.out.println("errorDescription : "+e.getErrorDescription());
        }


        try {
            Boolean confirmedResult = confirmationTokenService.setConfirmedAt("8a2d881e-758b-47c0-80bf-5b990ab8fafe");

        }
        catch (BaseExceptionModel e)
        {
            System.out.println("errorCode : "+e.getErrorCode());

            System.out.println("errorMessage : "+e.getErrorMessage());

            System.out.println("errorDescription : "+e.getErrorDescription());
        }

        Boolean deleteResult =  confirmationTokenService.deleteConfirmationToken(user);
*/

/*
        Role role_1 = new Role(1,"ADMIN","all_permission has one", LocalDateTime.now(),null);
        Role role_2 = new Role(2,"USER","user_permission has one",LocalDateTime.now(),null);
        Role role_3 = new Role(3,"STUDENT","student_permission has one",LocalDateTime.now(),null);

        roleDao.save(role_1);
     Role userRole =  roleDao.save(role_2);
        roleDao.save(role_3);

        HashSet<Role> roles = new HashSet<>();
        roles.add(userRole);

      User user =  userDao.save(new User(
           "",
           "hasan",
           "hasan@hasan",
                passwordEncoder.encode("hasan"),
                true,
                false,
                roles,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        System.out.println("kaydedilen kullanıcı : "+user.toString());*/

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.notebook_b.org"))
                .paths(PathSelectors.any())
                .build();
    }
  /*
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", (springfox.documentation.service.AuthorizationScope[]) authorizationScopes));
    }


@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .securityContexts(Arrays.asList(securityContext()))
      .securitySchemes(Arrays.asList(apiKey()))
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
}
 *  private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("Sallo Szrajbman", "www.baeldung.com", "salloszraj@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }*/

/*
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
