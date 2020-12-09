package com.ssafy.happyhouse.user.jwt.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.happyhouse.user.jwt.service.JwtService;

/**
 * 
 * @author : 김지현, 박재현
 * @description : Json-Web-Token 인터셉터 클래스로, Interceptor핸들러를 상속받기
 * 	- Interceptor : 쉽게 말해, 클라이언트에서 서버로 한 요청을 보내는 과정에 있어, Interceptor가 중간에 요청을 가로채 해당 정보의 어떠한 작업을 처리하는 것
 * 		- 정상 작업 완료되었다면, 서버로 보냄
 * 		- 비정상 작업 처리가되었다면, 클라이언트로 돌려보냄 
 *
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	/* jwt서비스 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 인터셉터 메소드 실행 => 요청의 토큰값 체킹 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getMethod().contentEquals("OPTIONS")) {
			return true;
		}
		else {	// CRUD (get, post, put, delete) 받아왔다면, 요청에서 헤더로 값 받아오기
			String token = request.getHeader("auth-token");	// 헤더로 받은 auth-token 값 받기 (유효한 토큰 받아내기)
			if(token != null && token.length() > 0) {
				jwtService.checkValid(token);
				return true;
			}
			else {
				throw new RuntimeException("인증 토큰이 만료되었습니다.");
			}
		}
	}
}
