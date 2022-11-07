package io.github.vilmosvegvari.chat_demo.ws;

import io.github.vilmosvegvari.chat_demo.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class ChatHandler extends TextWebSocketHandler {

    private final TestService testService;

    public ChatHandler(TestService testService) {
        this.testService = testService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        super.handleTextMessage(session, message);
        System.out.println(session.getId() + " " + message.toString());
        testService.messages.add(message.getPayload());
    }
}
