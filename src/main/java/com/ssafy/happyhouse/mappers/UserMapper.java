package com.ssafy.happyhouse.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.user.dto.User;

@Mapper
public interface UserMapper {
	public User selectUser(User user) throws Exception;
	public int insertUser(User user) throws Exception;
	public int updateUser(User user) throws Exception;
	public int deleteUser(User user) throws Exception;
	public int updateName(User user) throws Exception;
	public int isAllowId(User user) throws Exception;
	public int isAllowName(User user) throws Exception;
}
