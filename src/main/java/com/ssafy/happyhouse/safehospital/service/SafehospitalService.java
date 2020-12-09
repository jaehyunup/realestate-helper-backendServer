package com.ssafy.happyhouse.safehospital.service;

import java.util.List;

import com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO;

public interface SafehospitalService {

	List<SafehospitalDTO> getShList() throws Exception;

	List<SafehospitalDTO> getShListByCityAndGu(String sido_name, String gugun_name) throws Exception;

}