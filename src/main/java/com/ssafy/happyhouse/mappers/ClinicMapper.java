package com.ssafy.happyhouse.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.attention.dto.AttentionDTO;
import com.ssafy.happyhouse.clinic.dto.ClinicDTO;

@Mapper
public interface ClinicMapper {
	List<ClinicDTO> selectClinic() throws Exception;
	List<ClinicDTO> selectClinicByCityandGu(String sido_name, String gugun_name) throws Exception;
}
