package com.ssafy.happyhouse.clinic.dto;

import lombok.*;

/**
* @className   : ClinicDTO
* @author 	   : parkjaehyun
* @description : 안심병원 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-08       parkjaehyun     최초생성
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDTO {
	private String city;
	private String gu;
	private String hospital;
	private String address;
	private String weekdaytime;
	private String saterday;
	private String sunday;
	private String phonenumber;
}
