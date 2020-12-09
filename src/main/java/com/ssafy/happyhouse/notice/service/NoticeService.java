package com.ssafy.happyhouse.notice.service;

import java.util.List;

import com.ssafy.happyhouse.notice.dto.NoticeDto;

public interface NoticeService {

	List<NoticeDto> getNoticesList() throws Exception;
	
	NoticeDto getNoticesListByNumber(String number) throws Exception;

	List<NoticeDto> getNoticesListByTitle(String title) throws Exception;

	List<NoticeDto> getNoticesListByDescrib(String des) throws Exception;

	void renameNotice(NoticeDto notice) throws Exception;

	void deleteNotice(String title) throws Exception;

	void newNotice(NoticeDto notice) throws Exception;

}