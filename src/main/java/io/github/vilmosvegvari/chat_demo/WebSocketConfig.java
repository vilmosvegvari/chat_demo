package io.github.vilmosvegvari.chat_demo;

import io.github.vilmosvegvari.chat_demo.ws.ChatHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    public WebSocketConfig(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/chat").setAllowedOrigins("*");
    }

}
