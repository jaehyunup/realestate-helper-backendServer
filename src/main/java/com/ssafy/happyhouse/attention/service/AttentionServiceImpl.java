package com.ssafy.happyhouse.attention.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.attention.dto.AttentionDTO;
import com.ssafy.happyhouse.attention.dto.Bookmark;
import com.ssafy.happyhouse.mappers.AttentionMapper;
/**
 * @className   : AttentionServiceImpl
 * @author 	   : parkjaehyun
 * @date 	   : 2020-11-27
 * @description : 유저 관심지역, 매물 비즈니스 로직 구현 class
 */
@Service
public class AttentionServiceImpl implements AttentionService {
	@Autowired
	private AttentionMapper attentionMapper;

	@Override
	public List<AttentionDTO> selectAttention(AttentionDTO attentionDto) throws Exception {
		return attentionMapper.selectAttention(attentionDto);
	}
	@Override
	public int insertAttention(AttentionDTO attentionDto) throws Exception {
		return attentionMapper.insertAttention(attentionDto);
	}

	@Override
	public int deleteAttention(AttentionDTO attentionDto) throws Exception {
		return attentionMapper.deleteAttention(attentionDto);
	}

	@Override
	public int insertBookmark(String userId, int no) throws Exception {
		return attentionMapper.insertBookmark(userId,no);
	}

	@Override
	public int deleteBookmark(String userId, int no) throws Exception {
		return attentionMapper.deleteBookmark(userId, no);
	}

	@Override
	public List<Bookmark> selectBookmark(String userId, int no) throws Exception {
		return attentionMapper.selectBookmark(userId, no);
	}

}
