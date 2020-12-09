package com.ssafy.happyhouse.clinic.service;

import java.util.List;

import com.ssafy.happyhouse.clinic.dto.ClinicDTO;


/**
* @className   : ClinicService
* @author 	   : parkjaehyun
* @description : 안심병원기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-08       parkjaehyun     최초생성
*/
public interface ClinicService {
	List<ClinicDTO> getClinicList() throws Exception;
	List<ClinicDTO> getClinicListByCityAndGu(String sido_name, String gugun_name) throws Exception;

}