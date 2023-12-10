package com.poly.jwt;


import com.poly.controller.client.LoginController;
import com.poly.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtTokenProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

	// Doan JWT_SECRET nay chi co phia server duoc biet
	private static final String JWT_SECRET = "springboot-t5";

	// Thoi gian hieu luc cua JWT tinh bang miliseconds
	private static final long JWT_EXPIRATION = 604800000L;

	// Tao jwt tu thong tin CustomUser
	public String generateToken(CustomUser customUser,Role role) {
		LOGGER.info("com/poly/jwt/JwtTokenProvider.java - generateToken: START");
		if (customUser == null || role == null) {
			LOGGER.error("Invalid input: customUser or role is null");
			throw new IllegalArgumentException("Invalid input");
		}

		Date now = new Date();
		Map<String, Object> myMap = new HashMap<>();
		myMap.put("roles",role.getRoleName());
		LOGGER.info("My: "+role.getRoleName());
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		// Tao chuoi token tu username cua customUser
		return  Jwts.builder()
				.setSubject(customUser.getUser().getUsername())
				.setIssuedAt(now).setExpiration(expiryDate)
				.addClaims(myMap)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();

	}

	// Lay thong tin user tu chuoi token
	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty.");
		}
		return false;
	}

}
