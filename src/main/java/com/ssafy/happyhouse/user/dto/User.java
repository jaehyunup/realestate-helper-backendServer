package com.ssafy.happyhouse.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author : 김지현, 박재현
 * @description : 유저 DTO(VO) 클래스
 * 	디비에는 user_ + [id, pw, userName, age, auth] 이렇게 들어가있음.
 *
 */

@Getter
@Setter
@ToString
public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userAge;
	private String userAuth;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String userPw, String userName, String userAge, String userAuth) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userAuth = userAuth;
	}

	
}
