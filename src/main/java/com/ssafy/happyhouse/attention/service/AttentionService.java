package com.ssafy.happyhouse.attention.service;

import java.util.List;

import com.ssafy.happyhouse.attention.dto.AttentionDTO;
import com.ssafy.happyhouse.attention.dto.Bookmark;

/**
* @interfaceName   : AttentionService
* @author 	   : parkjaehyun
* @date 	   : 2020-11-27
* @description : 유저 관심지역, 매물 비즈니스로직을 추상화한 인터페이스
*/
public interface AttentionService {
	public List<AttentionDTO> selectAttention(AttentionDTO attentionDto) throws Exception;
	public int insertAttention(AttentionDTO attentionDto) throws Exception;
	public int deleteAttention(AttentionDTO attentionDto) throws Exception;
	public int insertBookmark(String userId,int no) throws Exception;
	public int deleteBookmark(String userId,int no) throws Exception;
	public List<Bookmark> selectBookmark(String userId,int no) throws Exception;
}
