package com.example.shop_online.usercontroller;


import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class ForgotPasswordController {

    @Autowired
    UserService userService;
    @Autowired
    JavaMailSender mailSender;

    public  void sendEmail(String email, String link) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

       helper.setTo(email);
        helper.setSubject("Click vào lick bến dưới để đến trang đặt lại mật khẩu");
        String content = "<p>Xin chào ,</p>"
                + "<p>Dưới đây là link để đặt lại mật khẩu </p>"
                + "<p>Click liên kết bên đươi để thay đổi mật khẩu</p>"
                + "<p><a href=\"" + link + "\">Thay đổi mật khẩu</a></p>"
                + "<br>"
                + "<p> Bỏ qua email này nếu bạn còn nhớ mật khẩu, "
                + "hoặc bạn không có nhu cầu thay đổi mật khẩu</p>";
        helper.setText(content,true);
        mailSender.send(message);
    }

    @PostMapping("/update-reset-token-user")
    public boolean insertResetPassToken(HttpServletRequest request, @RequestParam(name = "email") String email) throws MessagingException {
        String token = RandomString.make(30);
        boolean exist;
       boolean existEmail  = userService.updateResetPasswordToken(token,email);
       if (existEmail) {
           String resetPassLink = Utility.getSiteURL(request)+ "/reset_password?token=" + token;
           sendEmail(email,resetPassLink);
           exist = true;
       } else  {
           exist = false;
       }
       return exist;

    }




    @GetMapping("/reset_password")
    public void getFormRepass(HttpServletResponse response, @RequestParam(name = "token") String token) throws IOException {
        UserEntity user = userService.getByResetPasswordToken(token);
        String redirectUrl = "http://localhost:8080/update/pass"+"?token=" + token;
        ResponseData responseData;
        if(user==null) {
            responseData = new ResponseData(HttpStatus.NOT_FOUND.value(),Boolean.FALSE,"Mã thay đổi mật khẩu không hợp lệ",null);
        } else {
            response.sendRedirect(redirectUrl);
        }


    }


      @PostMapping("/reset_password")
    public ResponseEntity<?> resetPassword(@RequestParam(name = "token") String token, @RequestParam(name = "password") String pass)
      {
          ResponseData responseData;
          UserEntity user = userService.getByResetPasswordToken(token);
          if(user==null) {
                   responseData = new ResponseData(HttpStatus.NOT_FOUND.value(),Boolean.FALSE,"Mã thay đổi mật khẩu không hợp lệ",null);
          } else {
              userService.updatePassword(user,pass);
              responseData = new ResponseData(HttpStatus.OK.value(),Boolean.TRUE,"Thay đổi mật  khẩu thành công",null);
          }
          return new ResponseEntity<>(responseData,HttpStatus.OK);
      }

      @PostMapping("/change-password")
     public boolean changePassword(@RequestParam(name = "userId") int userId, @RequestParam(name = "newpass") String newpass)
      {
          return userService.changePass(userId,newpass);
      }





}
