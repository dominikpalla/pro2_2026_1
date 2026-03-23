package cz.uhk.spring1;

import cz.uhk.spring1.model.User;
import cz.uhk.spring1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Spring1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

    /*private UserService userService;

    @Autowired
    public Spring1Application(UserService userService) {
        this.userService = userService;
    }

    @Bean
    CommandLineRunner init(UserService userService, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setUsername("admin");
            user.setName("Administrátor");
            user.setPassword("heslo");
            user.setRole("ADMIN");
            user.setEmail("nereknu@cojetidotoho.com");
            userService.saveUser(user);
        };
    }*/

}
