package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    private static final String SECRET_KEY = "Zxs07E2JjXAFfS8GPuCCyOvHEWDG5GujHhxCmvdrPmI";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}