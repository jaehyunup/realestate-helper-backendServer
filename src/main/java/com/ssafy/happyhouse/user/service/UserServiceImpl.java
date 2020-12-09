package com.ssafy.happyhouse.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.UserMapper;
import com.ssafy.happyhouse.user.dto.User;

/**
 * 
 * @author : 김지현, 박재현
 * @description : User 서비스 클래스 오버라이딩
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	/* 로그인 메소드 : sqlSession을 통해 매퍼클래스 바로 수행 */
	@Override
	public User login(User user) throws Exception {
		User check = mapper.selectUser(user);
		if(user.getUserPw().equals(check.getUserPw()))
			return check;
		else
			return null;
	}

	/* 회원가입 메소드  */
	@Override
	public int createUser(User user) throws Exception {
		return mapper.insertUser(user);
	}

	/* 회원상세정보 메소드  */
	@Override
	public User selectUser(User user) throws Exception {
		return mapper.selectUser(user);
	}

	/* 회원정보 수정 메소드  */
	@Override
	public int updateUser(User user) throws Exception {
		return mapper.updateUser(user);
	}

	/* 회원 탈퇴 메소드 */
	@Override
	public int deleteUser(User user) throws Exception {
		return mapper.deleteUser(user);
	}
	
	/* 회원 비번찾기 메소드 */
	@Override
	public User selectPassword(User user) throws Exception {
		User check = mapper.selectUser(user);
		if(user.getUserId().equals(check.getUserId()))
			return check;
		else
			return null;
	}

	@Override
	public int isAllowId(User user) throws Exception {
		return mapper.isAllowId(user);

	}

	@Override
	public int isAllowName(User user) throws Exception {
		return mapper.isAllowName(user);

	}

	@Override
	public int updateName(User user) throws Exception {
		return mapper.updateName(user);
	}
}

/** 확인완료함(11/21) **/