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
* @className   : JwtService
* @author 	   : parkjaehyun
* @description : Jwt 인증 서비스 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-21       parkjaehyun     최초생성
*/
@Component
public class JwtService {
	/* 암호화 설정을 위한 임의 문자열 변수 */
	private String signature = "ForSignToken";

	public String create(User user) {
		/**
		 * @methodName  : create
		 * @params      : [user]
		 * @return      : java.lang.String
		 * @description : 사용자 정보를 기반으로 JWT Token을 생성하고, 반환한다
		 *
		 */
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setHeaderParam("typ", "JWT"); // 헤더 파라미터
		jwtBuilder.setSubject("loginToken") // 토큰 제목
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 토큰 유효기간 지정(30분)
				.claim("user", user).claim("greeting", user.getUserName() + "님 반갑습니다."); // 안내성 claim 담기
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());	// 시그니쳐를 이용해 암호화
		String jwt = jwtBuilder.compact();	// builder로 생성된 token -> String 직렬화
		return jwt;
	}

	public void checkValid(String jwt) {
		/**
		 * @methodName  : checkValid
		 * @params      : [jwt]
		 * @return      : void
		 * @description : 토큰의 유효성을 검증한다, 실패시 RuntimeException 발생
		 *
		 */
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
	}
	

	public Map<String, Object> get(String jwt) {
		/**
		 * @methodName  : get
		 * @params      : [jwt]
		 * @return      : java.util.Map<java.lang.String,java.lang.Object>
		 * @description : 토큰의 claim body를 반환
		 *
		 */
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
		} catch(final Exception e) {
			throw new RuntimeException();
		}
		
		return claims.getBody();
	}
}
