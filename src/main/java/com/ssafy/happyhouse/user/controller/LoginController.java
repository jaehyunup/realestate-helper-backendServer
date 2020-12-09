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
* @className   : LoginController
* @author 	   : parkjaehyun
* @description : 유저 로그인 기능 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/
@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response, HttpSession session) throws Exception {
		/**
		 * @methodName  : login
		 * @params      : [user, response, session]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : jwt 토큰 인증기반 유저 로그인
		 * @See : "jwt"
		 *
		 */
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
}
