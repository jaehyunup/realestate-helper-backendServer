package com.ssafy.happyhouse.notice.service;

import java.util.List;

import com.ssafy.happyhouse.notice.dto.NoticeDto;
/**
* @className   : NoticeService
* @author 	   : parkjaehyun
* @description : 공지사항 비즈니스로직을 추상화한 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-03       parkjaehyun     최초생성
*/
public interface NoticeService {
	List<NoticeDto> getNoticesList() throws Exception;
	NoticeDto getNoticesListByNumber(String number) throws Exception;
	List<NoticeDto> getNoticesListByTitle(String title) throws Exception;
	List<NoticeDto> getNoticesListByDescrib(String des) throws Exception;
	void renameNotice(NoticeDto notice) throws Exception;
	void deleteNotice(String title) throws Exception;
	void newNotice(NoticeDto notice) throws Exception;
}