package com.ssafy.happyhouse.map.service;

import java.util.List;

import com.ssafy.happyhouse.deal.dto.AmountHistory;
import com.ssafy.happyhouse.map.dto.HouseInfoDto;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;

public interface HouseMapService {
	
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	SidoGugunCodeDto getSidogugunByDong(String dong) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	List<Integer> getAreaByDongAndAptName(String dong,String AptName) throws Exception;
	List<AmountHistory> getAmountHistory(String dong,String AptName,String area) throws Exception;
}
