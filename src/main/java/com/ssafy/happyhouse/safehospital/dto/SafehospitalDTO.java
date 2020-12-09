package com.ssafy.happyhouse.safehospital.dto;

import lombok.*;

/**
* @className   : SafehospitalDTO
* @author 	   : parkjaehyun
* @description : 안심보건소 기능 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-15       parkjaehyun     최초생성
*/
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class SafehospitalDTO {
	private String city;
	private String gu;
	private String hospital;
	private String address;
	private String type;
	private String phonenumber;
}
