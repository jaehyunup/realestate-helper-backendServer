package com.ssafy.happyhouse.safehospital.service;

import java.util.List;

import com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO;

/**
* @className   : SafehospitalService
* @author 	   : parkjaehyun
* @description : 안심보건소 기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-14       parkjaehyun     최초생성
*/
public interface SafehospitalService {
	List<SafehospitalDTO> getShList() throws Exception;
	List<SafehospitalDTO> getShListByCityAndGu(String sido_name, String gugun_name) throws Exception;

}