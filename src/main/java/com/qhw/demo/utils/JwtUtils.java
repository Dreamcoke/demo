package com.qhw.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Map;

import static org.springframework.security.config.Elements.JWT;

public class JwtUtils {
    private final static String sing="@12dsafDSod*&";
    /**
     * 生成token
     */
    public static String  getToken(Map<String,Object> claims){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,7);
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, sing).compact();
        return token;
    }


    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token)
    {
        Claims claims=null;
        if (token==null){
            return claims;
        }
        try {
            claims= Jwts.parser()
                    .setSigningKey(sing)
                    .parseClaimsJws(token)
                    .getBody();

        }catch (Exception e){
            e.printStackTrace();
        }
        return claims;
    }
}
