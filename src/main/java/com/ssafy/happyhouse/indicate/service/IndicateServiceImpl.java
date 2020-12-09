package com.ssafy.happyhouse.indicate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.indicate.dto.IndicateDTO;
import com.ssafy.happyhouse.mappers.IndicateMapper;

/**
* @className   : IndicateServiceImpl
* @author 	   : parkjaehyun
* @description : 법정동 기준 시도군구 코드 반환기능 비즈니스로직 구현 클래스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-12-09       parkjaehyun     최초생성
*/
@Service
public class IndicateServiceImpl implements IndicateService {
	@Autowired
	private IndicateMapper indicateMapper;

	@Override
	public IndicateDTO getIndicateParams(String dong) throws Exception {
		/**
		 * @methodName  : getIndicateParams
		 * @params      : dong
		 * @return      : com.ssafy.happyhouse.indicate.dto.IndicateDTO
		 * @description : 법정동에서 맨마지막글자(동)를 제외하고 해당 이름기준으로 시도군구 코드를 조회한다
		 *
		 */
		return indicateMapper.selectIndicate(dong.substring(0,dong.length()-1));
	}
}
