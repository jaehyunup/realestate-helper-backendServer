package com.ssafy.happyhouse.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.deal.dto.AmountHistory;
import com.ssafy.happyhouse.map.dto.HouseInfoDto;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.mappers.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	@Autowired
	HouseMapMapper houseMapMapper;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return houseMapMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return houseMapMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseMapMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return houseMapMapper.getAptInDong(dong);
	}

	@Override
	public SidoGugunCodeDto getSidogugunByDong(String dong) throws Exception {
		return houseMapMapper.getSidogugunByDong(dong);
	}

	@Override
	public List<Integer> getAreaByDongAndAptName(String dong, String AptName) throws Exception {
		return houseMapMapper.getAreaByDongAndAptName(dong,AptName);
	}

	@Override
	public List<AmountHistory> getAmountHistory(String dong, String AptName, String area) throws Exception {
		return houseMapMapper.getAmountHistory(dong, AptName, area);

	}

}
