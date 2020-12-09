package com.ssafy.happyhouse.deal.dto;

import lombok.*;

/**
* @className   : DealDTO
* @author 	   : parkjaehyun
* @description : 아파트거래기능 DTO
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-13       parkjaehyun     최초생성
*/
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor@ToString
public class DealDTO {
	private int no;
	private String dong;
	private String AptName;
	private String code;
	private String dealAmount;
	private String buildYear;
	private String dealMonth;
	private String dealYear;
	private String dealDay;
	private String area;
	private String floor;
	private String jibun;
	private String type;
	private String rentMoney;
}
