package com.ssafy.happyhouse.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.deal.dto.AmountHistory;
import com.ssafy.happyhouse.map.dto.HouseInfoDto;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;
@Mapper
public interface HouseMapMapper {
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	SidoGugunCodeDto getSidogugunByDong(String dong) throws Exception;
	List<Integer> getAreaByDongAndAptName(@Param("dong")String dong,@Param("AptName")String AptName) throws Exception;
	List<AmountHistory> getAmountHistory(@Param("dong")String dong,@Param("AptName")String AptName,@Param("area")String area) throws Exception;
}
