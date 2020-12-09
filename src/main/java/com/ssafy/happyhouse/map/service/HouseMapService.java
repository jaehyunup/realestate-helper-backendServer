package com.ssafy.happyhouse.map.service;

import java.util.List;

import com.ssafy.happyhouse.deal.dto.AmountHistory;
import com.ssafy.happyhouse.map.dto.HouseInfoDto;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;

/**
* @className   : HouseMapService
* @author 	   : parkjaehyun
* @description : 아파트 정보 기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-09       parkjaehyun     최초생성
*/
public interface HouseMapService {
	public List<SidoGugunCodeDto> getSido() throws Exception;
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	public SidoGugunCodeDto getSidogugunByDong(String dong) throws Exception;
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	public List<Integer> getAreaByDongAndAptName(String dong,String AptName) throws Exception;
	public List<AmountHistory> getAmountHistory(String dong,String AptName,String area) throws Exception;
}
