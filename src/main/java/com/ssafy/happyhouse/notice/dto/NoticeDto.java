package com.ssafy.happyhouse.notice.dto;

public class NoticeDto {
	String notice_number;
	String notice_title;
	String notice_describ;

	public String getNotice_number() {
		return notice_number;
	}
	public void setNotice_number(String notice_number) {
		this.notice_number = notice_number;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_describ() {
		return notice_describ;
	}
	public void setNotice_describ(String notice_describ) {
		this.notice_describ = notice_describ;
	}
	
	public NoticeDto(String notice_number, String notice_title, String notice_describ) {
		super();
		this.notice_number = notice_number;
		this.notice_title = notice_title;
		this.notice_describ = notice_describ;
	}
	@Override
	public String toString() {
		return "NoticeDto [notice_number=" + notice_number + ", notice_title=" + notice_title + ", notice_describ="
				+ notice_describ + "]";
	}
	public NoticeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
