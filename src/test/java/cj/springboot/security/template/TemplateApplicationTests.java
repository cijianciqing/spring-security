package cj.springboot.security.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class TemplateApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

        System.out.println(passwordEncoder.matches("1111","$2a$10$zg/l6D8/A2hal6eUTHLVR.H/gkHjB3xP7y4Xcx8fV1eLJFGCMqIui"));
        System.out.println(passwordEncoder.matches("1111","$2a$10$zJcXofUecTR0wFwS5MF.y.5NP9BP4Az2qmFfm8nqfThp1S0qYn5qK"));
    }

}
