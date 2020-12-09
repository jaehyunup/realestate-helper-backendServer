package com.ssafy.happyhouse.attention.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
* @className   : Bookmark
* @author 	   : parkjaehyun
* @date 	   : 2020-12-09
* @description : 회원 관심매물 DTO
*/
public class Bookmark {
	private int bookmarkno;
	private String user_id;
	private int no;
}
