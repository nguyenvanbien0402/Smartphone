package com.example.shop_online.usercontroller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(maxAge = 3600)
@Controller
public class ChatEnpoint {
// vào /user1 thì gửi thông tin đến đường dẫn publish2
    @MessageMapping("/user1")
    @SendTo("/sample/publish2")
    public String publicMessage1(String message) {
        return  message;
    }
    // vào /user2 thì gửi thông tin đến đường dẫn publish1
    @MessageMapping("/user2")
    @SendTo("/sample/publish1")
    public String publicMessage2(String message) {
        return  message;
    }
}
