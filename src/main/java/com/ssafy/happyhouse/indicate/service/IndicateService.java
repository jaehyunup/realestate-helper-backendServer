package com.ssafy.happyhouse.indicate.service;

import com.ssafy.happyhouse.indicate.dto.IndicateDTO;

/**
* @className   : IndicateService
* @author 	   : parkjaehyun
* @description : 법정동기준 시도군구 코드 반환 기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/
public interface IndicateService {
	IndicateDTO getIndicateParams(String dong) throws Exception;
}