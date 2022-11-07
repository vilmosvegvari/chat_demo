package io.github.vilmosvegvari.chat_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChatDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatDemoApplication.class, args);
    }

}


