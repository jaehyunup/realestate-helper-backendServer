package com.ssafy.happyhouse.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.NoticeMapper;
import com.ssafy.happyhouse.notice.dto.NoticeDto;

/**
* @className   : NoticeServiceImpl
* @author 	   : parkjaehyun
* @description : 공지사항 비즈니스로직 구현 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-03       parkjaehyun     최초생성
*/
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public void newNotice(NoticeDto notice) throws Exception {
		/**
		 * @methodName  : newNotice
		 * @params      : [notice]
		 * @return      : void
		 * @description : 공지사항 추가
		 *
		 */
		noticeMapper.insertNotice(notice);
	}
	@Override
	public void renameNotice(NoticeDto notice) throws Exception {
		/**
		 * @methodName  : renameNotice
		 * @params      : [notice]
		 * @return      : void
		 * @description : 공지사항을 수정
		 *
		 */
		noticeMapper.updateNotice(notice);
	}
	
	@Override
	public void deleteNotice(String number) throws Exception {
		/**
		 * @methodName  : deleteNotice
		 * @params      : [number]
		 * @return      : void
		 * @description : 공지사항을 삭제
		 *
		 */
		noticeMapper.deleteNotice(number);
	}

	@Override
	public List<NoticeDto> getNoticesList() throws Exception {
		/**
		 * @methodName  : getNoticesList
		 * @params      : []
		 * @return      : java.util.List<com.ssafy.happyhouse.notice.dto.NoticeDto>
		 * @description : 모든 공지사항을 조회
		 *
		 */
		return noticeMapper.selectNotice();
	}

	@Override
	public NoticeDto getNoticesListByNumber(String number) throws Exception {
		/**
		 * @methodName  : getNoticesListByNumber
		 * @params      : [number]
		 * @return      : com.ssafy.happyhouse.notice.dto.NoticeDto
		 * @description : 공지사항을 번호기준으로 조회
		 *
		 */
		return noticeMapper.selectNoticeByNumber(number);
	}
	@Override
	public List<NoticeDto> getNoticesListByTitle(String title) throws Exception {
		/**
		 * @methodName  : getNoticesListByTitle
		 * @params      : [title]
		 * @return      : java.util.List<com.ssafy.happyhouse.notice.dto.NoticeDto>
		 * @description : 이름 기준으로 검색된 공지사항을 반환
		 *
		 */
		return noticeMapper.selectNoticeByTitle(title);
	}

	@Override
	public List<NoticeDto> getNoticesListByDescrib(String describ) throws Exception {
		/**
		 * @methodName  : getNoticesListByDescrib
		 * @params      : [describ]
		 * @return      : java.util.List<com.ssafy.happyhouse.notice.dto.NoticeDto>
		 * @description : 내용기준으로 검색된 공지사항을 반환
		 *
		 */
		return noticeMapper.selectNoticeByDescrib(describ);
	}

}
