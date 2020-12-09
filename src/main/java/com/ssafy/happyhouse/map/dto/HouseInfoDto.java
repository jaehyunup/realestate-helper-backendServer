package com.ssafy.happyhouse.map.dto;

import lombok.*;

/**
* @className   : HouseInfoDto
* @author 	   : parkjaehyun
* @description : 아파트 정보 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-10       parkjaehyun     최초생성
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseInfoDto {
	private String no;
	private String dong;
	private String aptName;
	private String code;
	private String buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
}
