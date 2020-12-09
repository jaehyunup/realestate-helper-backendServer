package com.ssafy.happyhouse.deal.dto;

import lombok.*;


/**
* @className   : AmountHistory
* @author 	   : parkjaehyun
* @description : 과거부터 지금까지의 아파트 거래가격 확인을위한 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AmountHistory {
	private String dealMonth;
	private String dealDay;
	private String dealAmount;
}
