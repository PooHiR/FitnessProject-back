package com.Ek0wraith.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName: JwtUtil
 * Package: com.Ek0wraith.utils
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 9:22
 * @Version 1.0
 */
public class JwtUtil {
    private static long time = 1000*60*60*24;
    private static String signature = "admin";
    public static String createToken(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    public static String createTokenToMember(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username","member")
                .claim("role","member")
                .setSubject("member-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();

        return jwtToken;
    }

    public static boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
