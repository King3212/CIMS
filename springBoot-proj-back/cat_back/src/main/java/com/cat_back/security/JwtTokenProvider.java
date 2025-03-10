package com.cat_back.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import java.util.*;
import org.springframework.security.core.Authentication;

@Component
public class JwtTokenProvider {

    private final String secretKey = Base64.getEncoder().encodeToString("您的密钥".getBytes());

    // 生成JWT
    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1小时有效期

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 验证JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("JWT令牌无效");
        }
    }

    // 从JWT中获取用户名
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public Authentication getAuthentication(String token) {
        // 从令牌中提取用户名
        String username = getUsername(token);

        // 从令牌中提取角色
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        List<String> roles = (List<String>) claims.get("roles");

        // 将角色转换为 GrantedAuthority 对象
        List<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // 创建 UserDetails 对象
        UserDetails userDetails = new User(username, "", authorities);

        // 返回 Authentication 对象
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}

