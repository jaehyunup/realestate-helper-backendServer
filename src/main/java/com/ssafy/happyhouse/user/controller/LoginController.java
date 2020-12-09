package com.ssafy.happyhouse.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.user.dto.User;
import com.ssafy.happyhouse.user.jwt.service.JwtService;
import com.ssafy.happyhouse.user.service.UserService;

/**
 * 
 * @author : 김지현
 * @description : 로그인/로그아웃 관리하는 Login컨트롤러 클래스
 *	// 로그인 시, 루트/user/login 매핑되어야함.
 *	// 일단 관리자도 여기로 로그인하는데, 관리자 데이터 체킹할때 이곳에서 따로 처리해줘야할듯..?
 *
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class LoginController {
	
	/* jwt 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* User 서비스 객체 불러오기 */
	@Autowired
	private UserService service;
	
	/* 로그인 기능 */
	@PostMapping("/login")	// <?> : 런타임 시점에 맞춰서 알아서 자료형들어간다..?
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response, HttpSession session) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		User check = service.login(user);
		
		if(check != null) {
			String token = jwtService.create(check);
			
			
			resultMap.put("auth-token", token);
			resultMap.put("userId", check.getUserId());
			resultMap.put("userName", check.getUserName());
			resultMap.put("userAuth", check.getUserAuth());
			
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		resultMap.put("message", "로그인에 실패하였습니다.");
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
	}
	
	/* 로그아웃 기능은 프론트엔드 단에서 토큰을 null로 해주기에 컨트롤러에서는 따로 코딩하지 않음 */

}

/** 확인완료함(11/21) => resultMap 저부분은 화면단에 로그인 정보를 가져와 표시하기 위함??? 한번 다시 볼필요 있음 **/
