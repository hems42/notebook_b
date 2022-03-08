package com.notebook_b.org;

import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.product.dto_convertor.principal_convertor.UserDtoConvertor;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.service.abstracts.IConfirmationTokenService;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableSwagger2
public class NotebookBApplication implements CommandLineRunner {

    @Autowired
    IConfirmationTokenService confirmationTokenService;

    @Autowired
    IUserService userService;

    @Autowired
    UserDtoConvertor userDtoConvertor;

    @Autowired
    RoleDao roleDao;

    public static void main(String[] args) {

        SpringApplication.run(NotebookBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {

       /* roleDao.save(new Role(
           null,
           "Admin",
           "deneme",
           LocalDateTime.now(),
           null
        ));

        System.out.println("comman bşladı...");*/

       // UserDto userDtoFound =userService.getUserById("2bfad829-05b9-406c-8d55-c438ba8cd6cc").getData();

      //  User userFound = userDtoConvertor.convert(userDtoFound);
//
//        ConfirmationToken tokenFound = confirmationTokenService.getConfirmationToken(userFound).get();
//
//        System.out.println("bulunan  user  : "+userFound.toString());
//
//        System.out.println("bulunan token : "+tokenFound);




    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.notebook_b.org"))
                .paths(PathSelectors.any())
                .build();
    }

}
