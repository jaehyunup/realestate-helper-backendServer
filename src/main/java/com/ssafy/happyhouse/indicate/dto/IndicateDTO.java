package com.ssafy.happyhouse.indicate.dto;

import lombok.Getter;
import lombok.Setter;

/**
* @className   : IndicateDTO
* @author 	   : parkjaehyun
* @description : 해당 법정동 시도군구 코드를 담을 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/
@Getter
@Setter
public class IndicateDTO {
	private int sidoCode;
	private String sidoName;
	private int dongCode;
	private String dongName;
}
