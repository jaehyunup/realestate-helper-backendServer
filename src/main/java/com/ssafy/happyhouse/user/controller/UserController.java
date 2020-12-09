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
 * 
 * @author : 김지현, 박재현
 * @description : 회원 관련 서비스 총모음 
 * 	- 루트/user/mypage : 회원정보보기(마이페이지)
 *	- 루트/user/join : 회원가입
 *	- 루트/user/delete : 회원탈퇴
 *	- 루트/user/edit : 회원정보수정
 * ...기타 관리자모드에서의 어떠한 작업은 나중에 추가할 것.
 * 
 */

@RestController
@RequestMapping("/user")
public class UserController {
	
	/* jwt 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 유저 서비스 객체 불러오기 */
	@Autowired
	private UserService userService;
	
	/* 마이페이지 */
	@GetMapping("/mypage")
	public ResponseEntity<Map<String, Object>> getMyPage(HttpServletRequest request) {
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
	/* 회원 가입 */
	@PostMapping
	public ResponseEntity<String> joinUser(@RequestBody User user) throws Exception{
		System.out.println(user);
		if(userService.createUser(user) > 0) {
			return new ResponseEntity<String>("회원가입성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("회원가입실패", HttpStatus.NO_CONTENT);
	}
	
	/* 회원 정보 수정 */
	@PutMapping("/mypage/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception {
		if(userService.updateUser(user) >= 0) {
			return new ResponseEntity<String>("업데이트 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("업데이트 실패", HttpStatus.NO_CONTENT);
	}
	
	
	/* 회원 탈퇴 => 서버에서 회원삭제 한 후, 로그아웃 처리(로그아웃하면 토큰도 삭제) */
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();

		User check = new User();
//		check.setUserId(request.getHeader("userId"));
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
	
	/* 유저이름중복체크 */
	@GetMapping("/check/id/{userId}")
	public ResponseEntity<?> checkId(@PathVariable(name="userId")String userId) {
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
	
	/* 유저 이름 변경*/
	@GetMapping("/change/{userId}/{userName}")
	public ResponseEntity<?> changeName(@PathVariable(name="userId")String userId,@PathVariable(name="userName")String userName) {
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

/** 확인완료함(11/21) => 이걸 스읍..흠...회원정보수정, 회원탈퇴 해야하노... **/