package com.ssafy.happyhouse.notice.dto;

import lombok.*;

/**
* @className   : NoticeDto
* @author 	   : parkjaehyun
* @description : 공지사항 기능 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-03       parkjaehyun     최초생성
*/
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class NoticeDto {
	private String notice_number;
	private String notice_title;
	private String notice_describ;
}
