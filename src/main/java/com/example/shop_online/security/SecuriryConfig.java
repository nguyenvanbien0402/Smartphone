package com.example.shop_online.security;

import com.example.shop_online.jwt.JwtTokenFilter;
import com.example.shop_online.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    JwtTokenFilter jwtTokenFilter;
   @Autowired
    UserDetailServiceImpl userDetailService;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }



    @Override
    protected void configure (HttpSecurity http) throws  Exception {

        http.cors().and().csrf().disable()
                // khong cho phep su dụng session de luu trang thai dang nhap
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/signin").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/all-home-product").permitAll()
                .antMatchers("/discount-product").permitAll()
                .antMatchers("/new-product").permitAll()
                .antMatchers("/special-product").permitAll()
                .antMatchers("/view-product").permitAll()
                .antMatchers("/selling-product").permitAll()
                .antMatchers("/user-category").permitAll()
                .antMatchers("/pro-by-type/{id}").permitAll()
                .antMatchers("/product/detail/{id}").permitAll()
                .antMatchers("/refresh-token").permitAll()
                .antMatchers("/user/order/{userId}").permitAll()
                .antMatchers("/user-order-fix/{orderId}").permitAll()
                .antMatchers("/delete-order-detail/{id}").permitAll()
                .antMatchers("/update-order-detail/{id}").permitAll()
                .antMatchers("/seach-product").permitAll()
                .antMatchers("/recevie-mail").permitAll()
                .antMatchers("/update-reset-token-user").permitAll()
                .antMatchers("/reset_password").permitAll()
                .antMatchers("/reset_password?token=**").permitAll()
                .antMatchers("/comment-by-productId/{id}").permitAll()
                .antMatchers("/file/**").permitAll()
                .antMatchers("/signin/test").authenticated()
                .anyRequest().authenticated();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//         thêm 1 filter trước 1 filter nào đó

    }
}
