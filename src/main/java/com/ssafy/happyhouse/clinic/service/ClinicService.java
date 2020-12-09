package com.ssafy.happyhouse.clinic.service;

import java.util.List;

import com.ssafy.happyhouse.clinic.dto.ClinicDTO;

public interface ClinicService {

	List<ClinicDTO> getClinicList() throws Exception;

	List<ClinicDTO> getClinicListByCityAndGu(String sido_name, String gugun_name) throws Exception;

}