package com.ssafy.happyhouse.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.notice.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	void insertNotice(NoticeDto notice) throws Exception;

	List<NoticeDto> selectNotice() throws Exception;
	
	NoticeDto selectNoticeByNumber(String number) throws Exception;
	
	List<NoticeDto> selectNoticeByTitle(String title) throws Exception;
	
	List<NoticeDto> selectNoticeByDescrib(String describ) throws Exception;

	void updateNotice(NoticeDto notice) throws Exception;

	void deleteNotice(String number) throws Exception;
}
