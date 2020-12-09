package com.ssafy.happyhouse.attention.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttentionDTO {
	private String dong;
	private String user_id;
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public AttentionDTO(String dong) {
		this.dong = dong;
	}

	public AttentionDTO(String dong, String user_id) {
		super();
		this.dong = dong;
		this.user_id = user_id;
	}

	public AttentionDTO() {
	}

	@Override
	public String toString() {
		return "AttentionDTO [dong=" + dong + ", user_id=" + user_id + "]";
	}
	
	
}
