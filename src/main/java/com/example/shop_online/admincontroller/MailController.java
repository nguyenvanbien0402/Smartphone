package com.example.shop_online.admincontroller;


import com.example.shop_online.common.MyConstants;
import com.example.shop_online.config.MailConfig;
import com.example.shop_online.payload.request.FeedBack;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Properties;


@RestController
public class MailController {





    @Autowired
        JavaMailSender mailSender;


        @PostMapping("/email")
        public ResponseEntity<ResponseData> SendEmailConfirm(@RequestParam(name = "orderDate") String orderDate,
                                                             @RequestParam(name = "orderId") String orderId,
                                                             @RequestParam(name = "amount") String amount,
                                                             @RequestParam(name = "phone") String phone,
                                                             @RequestParam(name = "address") String address,
                                                             @RequestParam(name = "email") String email
                                                            ) {

                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setTo(email);

                    message.setSubject("Đơn hàng của bạn đặt thành công");
                    message.setText( "Chào bạn:" +
                    "\nĐơn hàng của bạn đặt thành công với nội dung:" +
                    "\nMã đơn hàng:" + orderId +
                    "\nNgày đăt: " + orderDate +
                    "\nTổng tiền:" + amount +
                    "\nLiên lạc:" + phone +
                    "\nĐịa chỉ nhận hàng:" + address +
                                    "\n Thời gian giao hàng dự kiến từ 3 đến 4 ngày tới " +
                                    "\n bạn hãy để ý điện thoại người giao hàng sẽ liên lạc" +
                                    "\n hình thức thanh toán là nhận hàng, kiểm tra , thanh toán" +
                                    "\n cảm ơn đã đặt hàng tại HOANGHAMOBILE.COM.VN"+
                                    "\n đây là tin nhắn tự động không yêu cầu trả lời"
                    );

             mailSender.send(message);
            ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"Gửi mail xác nhận thành công", null);
            return new ResponseEntity<>(responseData,HttpStatus.OK);
        }


        @PostMapping("/recevie-mail")
       public ResponseEntity<?> feedBack( @RequestBody FeedBack feedBack) {

               JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
               mailSender.setHost("smtp.gmail.com");
               mailSender.setPort(587);

               mailSender.setUsername(feedBack.getEmail());
               mailSender.setPassword(feedBack.getPassword());

               Properties props = mailSender.getJavaMailProperties();
               props.put("mail.transport.protocol", "smtp");
               props.put("mail.smtp.auth", "true");
               props.put("mail.smtp.starttls.enable", "true");
               props.put("mail.debug", "true");


                   SimpleMailMessage message = new SimpleMailMessage();
                   message.setTo("bienn270@gmail.com");
                   message.setSubject("Phản hồi ý kiến");
                   message.setFrom(feedBack.getEmail());
                   message.setText("Phản hồi: " + feedBack.getContent()
                            + "\nSố điện thoại: " + feedBack.getPhone()
                    );
           mailSender.send(message);
           ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"Gửi mail xác nhận thành công", null);
           return new ResponseEntity<>(responseData,HttpStatus.OK);

       }

}
