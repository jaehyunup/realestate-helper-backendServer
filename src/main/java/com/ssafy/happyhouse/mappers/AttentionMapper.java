package com.ssafy.happyhouse.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.attention.dto.AttentionDTO;
import com.ssafy.happyhouse.attention.dto.Bookmark;

@Mapper
public interface AttentionMapper {
	public List<AttentionDTO> selectAttention(AttentionDTO attentionDto) throws Exception;
	public int insertAttention(AttentionDTO attentionDto) throws Exception;
	public int deleteAttention(AttentionDTO attentionDto) throws Exception;
	public int insertBookmark(@Param("userId") String userId,@Param("no") int no) throws Exception;
	public int deleteBookmark(@Param("userId") String userId,@Param("no") int no) throws Exception;
	public List<Bookmark> selectBookmark(@Param("userId") String userId,@Param("no") int no) throws Exception;
}
