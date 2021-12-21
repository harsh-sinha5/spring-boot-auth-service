package com.covidmgmt.user.util;

import com.covidmgmt.user.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtUtil {

            private String SECRET_KEY = "secret";

        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        public Claims extractAllClaims(String token){
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        }

        public String extractUserName(String token){
            return extractClaim(token, Claims::getSubject);
        }

        public Set<String> extractRole(String token){
            Claims claims = extractAllClaims(token);
            return Arrays.stream(claims.toString().split(",")).collect(Collectors.toSet());
        }

        public Date extractExpiration(String token){
            return extractClaim(token, Claims::getExpiration);
        }

        private Boolean isTokenExpired(String token){
            return extractExpiration(token).before(new Date());
        }

        public String generateToken(CustomUserDetails userDetails){
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", userDetails.getAuthorities());
            claims.put("cityName", userDetails.getCityName());
            claims.put("pinCode", userDetails.getPinCode());
            claims.put("hospitalId", userDetails.getHospitalId());
            claims.put("hospitalBranchId", userDetails.getBranchId());
            return createToken(claims, userDetails.getUsername());
        }

        public String createToken(Map<String, Object> claims, String subject){
            return  Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                          .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))

                          .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        }

        public Boolean validateToken(String token, UserDetails userDetails){
            final String username = extractUserName(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }
}
