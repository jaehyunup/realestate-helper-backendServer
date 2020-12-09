package com.ssafy.happyhouse.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.UserMapper;
import com.ssafy.happyhouse.user.dto.User;

/**
* @className   : UserServiceImpl
* @author 	   : parkjaehyun
* @description : 유저관리 기능 비즈니스로직 구현 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-21       parkjaehyun     최초생성
*/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	@Deprecated
	@Override
	public User login(User user) throws Exception {
		/**
		 * @methodName  : login
		 * @params      : [user]
		 * @return      : com.ssafy.happyhouse.user.dto.User
		 * @description : 일반적 로그인
		 * @deprecated  : JWT 기반 로그인 수행으로 업데이트되어 사용하지 않습니다.
		 * @See         : com.ssafy.happyhouse.user.jwt.service.JwtService
		 *
		 */
		User check = mapper.selectUser(user);
		if(user.getUserPw().equals(check.getUserPw()))
			return check;
		else
			return null;
	}

	@Override
	public int createUser(User user) throws Exception {
		/**
		 * @methodName  : createUser
		 * @params      : [user]
		 * @return      : int
		 * @description : 유저가입
		 *
		 */
		return mapper.insertUser(user);
	}

	@Override
	public User selectUser(User user) throws Exception {
		/**
		 * @methodName  : selectUser
		 * @params      : [user]
		 * @return      : com.ssafy.happyhouse.user.dto.User
		 * @description : 유저 상세정보 보기
		 *
		 */
		return mapper.selectUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		/**
		 * @methodName  : updateUser
		 * @params      : [user]
		 * @return      : int
		 * @description : 회원정보수정
		 *
		 */
		return mapper.updateUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		/**
		 * @methodName  : deleteUser
		 * @params      : [user]
		 * @return      : int
		 * @description : 회원정보 삭제
		 *
		 */
		return mapper.deleteUser(user);
	}

	@Override
	public User selectPassword(User user) throws Exception {
		/**
		 * @methodName  : selectPassword
		 * @params      : [user]
		 * @return      : com.ssafy.happyhouse.user.dto.User
		 * @description : 비밀번호 찾기
		 *
		 */
		User check = mapper.selectUser(user);
		if(user.getUserId().equals(check.getUserId()))
			return check;
		else
			return null;
	}

	@Override
	public int isAllowId(User user) throws Exception {
		/**
		 * @methodName  : isAllowId
		 * @params      : [user]
		 * @return      : int
		 * @description : 아이디 중복검사
		 *
		 */
		return mapper.isAllowId(user);
	}

	@Override
	public int isAllowName(User user) throws Exception {
		/**
		 * @methodName  : isAllowName
		 * @params      : [user]
		 * @return      : int
		 * @description : 닉네임 중복검사
		 *
		 */
		return mapper.isAllowName(user);

	}

	@Override
	public int updateName(User user) throws Exception {
		return mapper.updateName(user);
	}
}
