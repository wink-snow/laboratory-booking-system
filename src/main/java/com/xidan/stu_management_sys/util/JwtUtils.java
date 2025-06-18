package com.xidan.stu_management_sys.util;

import com.xidan.stu_management_sys.Pojo.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET = "myjnb66666666666666666666666666666666666666666666666666";
    private static final long EXPIRE = 1000 * 60 * 60 * 24;   // 24 h

    public static String generateJwt(UserInfo user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getUserId()))
                .claim("role", user.getRole())
                .claim("username", user.getUsername())
                .claim("password", user.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
                return claims;
    }
}
