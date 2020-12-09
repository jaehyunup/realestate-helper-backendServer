package com.ssafy.happyhouse.user.dto;

import lombok.*;

/**
* @className   : User
* @author 	   : parkjaehyun
* @description : 유저 관련 DTO 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-21       parkjaehyun     최초생성
*/
@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userAge;
	private String userAuth;
}
