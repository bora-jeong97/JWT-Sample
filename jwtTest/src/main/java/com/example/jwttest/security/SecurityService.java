package com.example.jwttest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityService {

    private static final String SECRET_KEY = "aasdjasklfdskjfisdfjlsfalidafsewafafdfjklsjdflkajiejldjkfljfklajlkfsjdlkjfdjalkfj";

    // 토큰 생성
    public String createToken(String subject, long expTime) { // (userId == subject , 만료시간)
        if(expTime <= 0) {
            throw new RuntimeException("만료시간이 0보다 커야합니다");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;  // HS256 시그니처 알고리즘 적용

        byte[] secreatKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingkey = new SecretKeySpec(secreatKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .signWith(signingkey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact();
    }

    //토큰 검증 및 복호화
    public String getSubject(String token){  // 정상 수행된다면 해당 토큰은 정상토큰

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
