package com.ssafy.happyhouse.map.dto;

import lombok.*;
/**
* @className   : SidoGugunCodeDto
* @author 	   : parkjaehyun
* @description : 시도군구 코드 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-11       parkjaehyun     최초생성
*/
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class SidoGugunCodeDto {
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
}
