package com.ssafy.happyhouse.user.service;

import com.ssafy.happyhouse.user.dto.User;


/**
* @className   : UserService
* @author 	   : parkjaehyun
* @description : 유저 관리 기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-19       parkjaehyun     최초생성
*/
public interface UserService {
	/* 로그인 메소드 */
	@Deprecated
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