package com.ssafy.happyhouse.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.user.dto.User;
import com.ssafy.happyhouse.user.jwt.service.JwtService;
import com.ssafy.happyhouse.user.service.UserService;

/**
* @className   : UserController
* @author 	   : parkjaehyun
* @description : 유저 관리기능 제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;

	@GetMapping("/isAccepted")
	public ResponseEntity<Map<String, Object>> getMyPage(HttpServletRequest request) {
		/**
		 * @methodName  : isAccepted
		 * @params      : [request]
		 * @return      : org.springframework.http.ResponseEntity<java.util.Map<java.lang.String,java.lang.Object>>
		 * @description : 클라이언트측의 토큰값의 유효성 검사
		 * @See         : "Jwt인증으로, Request 헤더의 토큰을 확인합니다"
		 */
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.putAll(jwtService.get(request.getHeader("auth-token")));
			status = HttpStatus.ACCEPTED;
		} catch(RuntimeException e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}


	@PostMapping
	public ResponseEntity<String> joinUser(@RequestBody User user) throws Exception{
		/**
		 * @methodName  : joinUser
		 * @params      : [user]
		 * @return      : org.springframework.http.ResponseEntity<java.lang.String>
		 * @description : 유저 회원가입
		 *
		 */
		if(userService.createUser(user) > 0) {
			return new ResponseEntity<String>("회원가입성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("회원가입실패", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/mypage/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception {
		/**
		 * @methodName  : updateUser
		 * @params      : [user]
		 * @return      : org.springframework.http.ResponseEntity<java.lang.String>
		 * @description : 회원정보 수정
		 *
		 */
		if(userService.updateUser(user) >= 0) {
			return new ResponseEntity<String>("업데이트 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("업데이트 실패", HttpStatus.NO_CONTENT);
	}
	
	
	/* 회원 탈퇴 => 서버에서 회원삭제 한 후, 로그아웃 처리(로그아웃하면 토큰도 삭제) */
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		/**
		 * @methodName  : deleteUser
		 * @params      : [id]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 회원탈퇴
		 * @See         : JWT 토큰 Free 및 DB 유저 삭제
		 */
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();
		User check = new User();
		check.setUserId(id);
		try {
			if(userService.deleteUser(check) >= 0) {
				resultMap.put("message", "회원이 삭제되었습니다.");
				status = HttpStatus.ACCEPTED;
			}else {
				resultMap.put("message", "회원 삭제하는데 문제가 발생하였습니다.");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch(Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>("회원삭제처리", status);
	}
	
	@GetMapping("/check/id/{userId}")
	public ResponseEntity<?> checkId(@PathVariable(name="userId")String userId) {
		/**
		 * @methodName  : checkId
		 * @params      : [userId]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 유저아이디 중복체크
		 *
		 */
		User t=new User();
		t.setUserId(userId);
		try {
		if(userService.isAllowId(t)==0) { // 중복없을때
			return new ResponseEntity<>("true", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("false", HttpStatus.OK);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("false", HttpStatus.BAD_GATEWAY);
	}


	/* 유저이름 중복체크 */
	@GetMapping("/check/name/{userName}")
	public ResponseEntity<?> checkName(@PathVariable(name="userName")String userName) {
		/**
		 * @methodName  : checkName
		 * @params      : [userName]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 유저 닉네임 중복체크
		 *
		 */
		User t=new User();
		t.setUserName(userName);
		try {
		if(userService.isAllowName(t)==0) { // 중복없을때
			return new ResponseEntity<>("true", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("false", HttpStatus.OK);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("false", HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/change/{userId}/{userName}")
	public ResponseEntity<?> changeName(@PathVariable(name="userId")String userId,@PathVariable(name="userName")String userName) {
		/**
		 * @methodName  : changeName
		 * @params      : [userId, userName]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 유저 닉네임 변경
		 *
		 */
		User t=new User();
		t.setUserName(userName);
		t.setUserId(userId);
		try {
			return new ResponseEntity<>(userService.updateName(t), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("false", HttpStatus.OK);
		}
	}
	
}