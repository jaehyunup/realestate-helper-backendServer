package com.ssafy.happyhouse.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.NoticeMapper;
import com.ssafy.happyhouse.notice.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	


	@Override
	public List<NoticeDto> getNoticesList() throws Exception {
		return noticeMapper.selectNotice();
	}
	
	@Override
	public List<NoticeDto> getNoticesListByTitle(String title) throws Exception {
		return noticeMapper.selectNoticeByTitle(title);
	}

	@Override
	public List<NoticeDto> getNoticesListByDescrib(String describ) throws Exception {
		return noticeMapper.selectNoticeByDescrib(describ);
	}
	
	@Override
	public void renameNotice(NoticeDto notice) throws Exception {
		noticeMapper.updateNotice(notice);
	}
	
	@Override
	public void deleteNotice(String number) throws Exception {
		noticeMapper.deleteNotice(number);
	}
	
	@Override
	public void newNotice(NoticeDto notice) throws Exception {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public NoticeDto getNoticesListByNumber(String number) throws Exception {
		return noticeMapper.selectNoticeByNumber(number);
	}


}
