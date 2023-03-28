package com.example.shop_online.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenHelper {

    private final  String strKey = "U2VjcmV0a2V5Zm9yZm9vZGRlbGl2ZXJ5bW9yZXNlY3VyZXRpYW5kYmllbnRoYWliaW5oMTc=";
    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
    public String generateJwtToken(String  email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + (1000 * 60 * 60 * 2400)))
                .signWith(secretKey,SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean  validateToken(String token) {
        // giải mã token với mã bí mật / giải mã thành công trả ra true
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
        boolean isSuccess = false;
        try {
            Jwts.parserBuilder().setSigningKey(secretKey)
                    .build().parseClaimsJws(token);
            isSuccess = true;
        }
        catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty");
        }
        return isSuccess;
    }
}
