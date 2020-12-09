package com.ssafy.happyhouse.attention.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
* @className   : AttentionDTO
* @author 	   : parkjaehyun
* @date 	   : 2020-12-09
* @description : 유저 관심지역 DTO
*/
public class AttentionDTO {
	private String dong;
	private String user_id;
	public AttentionDTO() {}
	public AttentionDTO(String dong) {
		this.dong = dong;
	}
	public AttentionDTO(String dong, String user_id) {
		this.dong = dong;
		this.user_id = user_id;
	}
}
