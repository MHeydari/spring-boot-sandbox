package io.dummy.websocket.controller;

import io.dummy.websocket.message.HelloMessage;
import io.dummy.websocket.message.HelloReplyMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/helloReply")
    public HelloReplyMessage greeting(@Payload HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        Thread.sleep(1000); // simulated delay

        System.out.println("Hello from  " + message.getName() + " ip (" + headerAccessor.getSessionId() + ")");
        return new HelloReplyMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
