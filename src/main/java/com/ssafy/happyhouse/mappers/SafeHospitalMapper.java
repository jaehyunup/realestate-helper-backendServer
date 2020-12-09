package com.ssafy.happyhouse.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO;
@Mapper
public interface SafeHospitalMapper {
	List<SafehospitalDTO> selectSafehospital() throws Exception;
	List<SafehospitalDTO> selectSafehospitalByCityandGu(String sido_name, String gugun_name) throws Exception;
}