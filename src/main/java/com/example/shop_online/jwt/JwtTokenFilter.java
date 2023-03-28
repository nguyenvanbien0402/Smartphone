package com.example.shop_online.jwt;

import com.example.shop_online.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @Autowired
    CustomUserDetailService customUserDetailService;

    // get token from request
    private  String getTokenFromHeader (HttpServletRequest request) {
        // lấy ra giá trị của header có key là Authorization
        String strToken  = request.getHeader("Authorization");
        // kiểm tra xem strToken có kí tự hay không, và có bắt đầu bằng bearer hay khoog
        if(StringUtils.hasText(strToken) && strToken.startsWith("Bearer ")) {
            String finalToken = strToken.substring(7);
            return  finalToken;
        } else
        {
            return  null;
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String   token  = getTokenFromHeader(request);
        try
        {
            if (token!=null) {
                if (jwtTokenHelper.validateToken(token)) {
                    if (StringUtils.hasText(token)) {
                        // lấy username tử token
                        String username = jwtTokenHelper.getUserNameFromJwtToken(token);
                        //laasuy userdetai dựa trên username
                        // và xác thực , xác thực ok thì lưu vào contextHolder
                        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Could not set user authentication in security context");
        }
        filterChain.doFilter(request, response);
    }
}
