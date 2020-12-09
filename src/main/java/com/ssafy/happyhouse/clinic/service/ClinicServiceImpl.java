package com.ssafy.happyhouse.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.clinic.dto.ClinicDTO;
import com.ssafy.happyhouse.mappers.ClinicMapper;

/**
* @className   : ClinicServiceImpl
* @author 	   : parkjaehyun
* @description : 안심병원기능 비즈니스로직 구현 계층
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-08       parkjaehyun     최초생성
*/
@Service
public class ClinicServiceImpl implements ClinicService {
	@Autowired
	private ClinicMapper clinicMapper;

	@Override
	public List<ClinicDTO> getClinicList() throws Exception {
		/**
		 * @methodName  : getClinicList
		 * @params      : []
		 * @return      : java.util.List<com.ssafy.happyhouse.clinic.dto.ClinicDTO>
		 * @description : 전국 모든 안심병원 조회
		 *
		 */
		return clinicMapper.selectClinic();
	}

	@Override
	public List<ClinicDTO> getClinicListByCityAndGu(String sido_name, String gugun_name) throws Exception {
		/**
		 * @methodName  : getClinicListByCityAndGu
		 * @params      : [sido_name, gugun_name]
		 * @return      : java.util.List<com.ssafy.happyhouse.clinic.dto.ClinicDTO>
		 * @description : 시/도 ,구/군 이름을 파라미터로 지역구 내 안심병원 조회
		 *
		 */
		return clinicMapper.selectClinicByCityandGu(sido_name.substring(0,2), gugun_name);
	}
}
