package com.ssafy.happyhouse.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.user.dto.User;

/**
 * 
 * @author : 김지현, 박재현
 * @description : 회원 관련 Mapper 인터페이스 클래스
 *
 */

@Mapper
public interface UserMapper {
	/* 로그인, 회원상세정보 조회, 비밀번호찾기 활용 */
	public User selectUser(User user) throws Exception;
	
	/* 회원가입 메소드 */
	public int insertUser(User user) throws Exception;
	
	/* 회원정보수정 메소드 */
	public int updateUser(User user) throws Exception;
	
	/* 회원탈퇴 메소드 */
	public int deleteUser(User user) throws Exception;
	
	/* 닉네임 변경 메소드*/
	public int updateName(User user) throws Exception;
	public int isAllowId(User user) throws Exception;
	public int isAllowName(User user) throws Exception;
	
}
