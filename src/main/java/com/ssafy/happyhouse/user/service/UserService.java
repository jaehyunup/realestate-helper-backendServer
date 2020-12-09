package com.ssafy.happyhouse.user.service;

import com.ssafy.happyhouse.user.dto.User;

/**
 * 
 * @author : 김지현, 박재현
 * @description : User 서비스 인터페이스 클래스
 * 	1) 로그인/로그아웃 메소드 (로그아웃은 프론트엔드에서 토큰 null로 처리해버림)
 *  2) 회원가입, 비밀번호찾기
 *  3) 회원 => 회원상세조회, 회원정보수정, 회원탈퇴
 *  4) 관리자 => 회원전체조회 및 검색, 회원수정 등 추후 관리자 서비스 추가...
 *  
 */

public interface UserService {
	/* 로그인 메소드 */
	public User login(User user) throws Exception;
	
	/* 회원가입 메소드 */
	public int createUser(User user) throws Exception;
	
	/* 회원상세조회 메소드 */
	public User selectUser(User user) throws Exception;
	
	/* 회원정보수정 메소드 */
	public int updateUser(User user) throws Exception;
	
	/* 회원탈퇴 메소드 */
	public int deleteUser(User user) throws Exception;
	
	/* 비밀번호찾기 메소드 */
	public User selectPassword(User user) throws Exception;
	
	/* 아이디 중복 확인 메소드 */
	public int isAllowId(User user) throws Exception;
	
	/* 이름 중복 확인 메소드 */
	public int isAllowName(User user) throws Exception;
	/* 닉네임 수정 메소드*/
	public int updateName(User user) throws Exception;

}

/** 확인완료함(11/21) **/