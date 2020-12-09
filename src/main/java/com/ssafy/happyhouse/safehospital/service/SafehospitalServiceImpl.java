package com.ssafy.happyhouse.safehospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.SafeHospitalMapper;
import com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO;
/**
* @className   : SafehospitalServiceImpl
* @author 	   : parkjaehyun
* @description : 안심보건소기능 비즈니스로직 구현 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-14       parkjaehyun     최초생성
*/
@Service
public class SafehospitalServiceImpl implements SafehospitalService {
	@Autowired
	private SafeHospitalMapper safeHospitalMapper;
	
	@Override
	public List<SafehospitalDTO> getShList() throws Exception {
		/**
		 * @methodName  : getShList
		 * @params      : []
		 * @return      : java.util.List<com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO>
		 * @description : 모든 안심병원 리스트를 반환한다
		 *
		 */
		return safeHospitalMapper.selectSafehospital();
	}
	
	@Override
	public List<SafehospitalDTO> getShListByCityAndGu(String sido_name, String gugun_name) throws Exception {
		/**
		 * @methodName  : getShListByCityAndGu
		 * @params      : [sido_name, gugun_name]
		 * @return      : java.util.List<com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO>
		 * @description : 시도,구군 이름을 받아 해당 시도,구군 내 모든 안심병원 리스트를 반환한다.
		 *
		 */
		return safeHospitalMapper.selectSafehospitalByCityandGu(sido_name.substring(0,2), gugun_name);
	}
}
