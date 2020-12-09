package com.ssafy.happyhouse.user.jwt.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ssafy.happyhouse.user.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



/**
 * 
 * @author : 김지현, 박재현
 * @description : Jwt 서비스 클래스
 *
 */

@Component
public class JwtService {
	
	/* 암호화 설정을 위한 임의 문자열 변수 */
	private String signature = "ForSignToken";
	
	/* 로그인 성공시, 사용자 정보를 기반으로 JWTToken을 생성하여 반환 */
	public String create(User user) {
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setHeaderParam("typ", "JWT"); // 헤더설정 => 토큰의 타입으로 고정 값 ???
		jwtBuilder.setSubject("로그인토큰")	// 토큰의 제목  설정
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 유효기간 설정 : 30분
				.claim("user", user).claim("greeting", user.getUserName() + "님 반갑습니다."); // 담고싶은 정보 설정 => .claim으로 정보 계속 담기 가능
		
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());	// 토큰 암호화 처리
		
		String jwt = jwtBuilder.compact();	// 마지막 직렬화 처리
		return jwt;
	}
	
	/* 제대로 생성되어 전달받은 토큰 확인 => 문제가 존재한다면, RuntimeException 처리 */
	public void checkValid(String jwt) {
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt); // 예외가 발생하지않으면 ok 이건 무슨말이지...
	}
	
	/* JWT 토큰을 분석해서 필요한 정보를 반환 */
	public Map<String, Object> get(String jwt) {
		Jws<Claims> claims = null;	// claims는 Map의 구현체로 활용
		try {
			claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
		} catch(final Exception e) {
			throw new RuntimeException();
		}
		
		return claims.getBody();
	}
}
