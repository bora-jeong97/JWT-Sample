package com.example.jwttest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    // token 생성
    @PostMapping("/create/token")
    public Map<String, Object> createToken(@RequestParam(value = "subject") String subject) {

        String token = securityService.createToken(subject, (5*1000*60));  // 토큰 유지시간 5분
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);
        return map;
    }

    // 검증 및 복호화
    @PostMapping("/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value = "token") String token) {
        String subject = securityService.getSubject(token);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);
        return map;

    }

}
