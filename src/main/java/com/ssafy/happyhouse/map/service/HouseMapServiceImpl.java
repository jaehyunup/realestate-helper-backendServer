package com.ssafy.happyhouse.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.deal.dto.AmountHistory;
import com.ssafy.happyhouse.map.dto.HouseInfoDto;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.mappers.HouseMapMapper;

/**
* @className   : HouseMapServiceImpl
* @author 	   : parkjaehyun
* @description : 아파트 정보 기능 비즈니스로직 구현 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-09       parkjaehyun     최초생성
*/
@Service
public class HouseMapServiceImpl implements HouseMapService {
	@Autowired
	private HouseMapMapper houseMapMapper;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		/**
		 * @methodName  : getSido
		 * @params      : []
		 * @return      : java.util.List<com.ssafy.happyhouse.map.dto.SidoGugunCodeDto>
		 * @description : 모든 시/도를 반환한다
		 *
		 */
		return houseMapMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		/**
		 * @methodName  : getGugunInSido
		 * @params      : [sido]
		 * @return      : java.util.List<com.ssafy.happyhouse.map.dto.SidoGugunCodeDto>
		 * @description : 시/도에 속한 구/군을 반환한다
		 *
		 */
		return houseMapMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		/**
		 * @methodName  : getDongInGugun
		 * @params      : [gugun]
		 * @return      : java.util.List<com.ssafy.happyhouse.map.dto.HouseInfoDto>
		 * @description : 구/군에 속한 모든 동을 반환한다
		 *
		 */
		return houseMapMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		/**
		 * @methodName  : getAptInDong
		 * @params      : [dong]
		 * @return      : java.util.List<com.ssafy.happyhouse.map.dto.HouseInfoDto>
		 * @description : 아파트에 속한 모든 동을 반환한다
		 *
		 */
		return houseMapMapper.getAptInDong(dong);
	}

	@Override
	public SidoGugunCodeDto getSidogugunByDong(String dong) throws Exception {
		/**
		 * @methodName  : getSidogugunByDong
		 * @params      : [dong]
		 * @return      : com.ssafy.happyhouse.map.dto.SidoGugunCodeDto
		 * @description : 법정동을 기준으로 시도군구 코드를 반환한다
		 *
		 */
		return houseMapMapper.getSidogugunByDong(dong);
	}

	@Override
	public List<Integer> getAreaByDongAndAptName(String dong, String AptName) throws Exception {
		/**
		 * @methodName  : getAreaByDongAndAptName
		 * @params      : [dong, AptName]
		 * @return      : java.util.List<java.lang.Integer>
		 * @description : 해당 아파트의 모든 평수(전용면적타입별)을 반환한다
		 *
		 */
		return houseMapMapper.getAreaByDongAndAptName(dong,AptName);
	}

	@Override
	public List<AmountHistory> getAmountHistory(String dong, String AptName, String area) throws Exception {
		/**
		 * @methodName  : getAmountHistory
		 * @params      : [dong, AptName, area]
		 * @return      : java.util.List<com.ssafy.happyhouse.deal.dto.AmountHistory>
		 * @description : 해당 아파트 거래 내역을 반환한다.
		 *
		 */
		return houseMapMapper.getAmountHistory(dong, AptName, area);

	}

}
