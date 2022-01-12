package com.notebook_b.org;

import com.notebook_b.org.business.concrete.UserService;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NotebookBApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(NotebookBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        UserRequestCreate requestCreate= new UserRequestCreate(
                "caglar",
                "eflatun126@gmail.com",
                "1122334455"
        );

       UserDto userDto = userService.createUser(requestCreate).getData();

        System.out.println("kayıt başarılı");
        System.out.println(userDto.toString());

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.notebook_b.org"))
                .build();
    }
}
