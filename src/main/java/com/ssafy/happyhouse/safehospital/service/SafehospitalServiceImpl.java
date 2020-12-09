package com.ssafy.happyhouse.safehospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.mappers.SafeHospitalMapper;
import com.ssafy.happyhouse.safehospital.dto.SafehospitalDTO;
@Service
public class SafehospitalServiceImpl implements SafehospitalService {
	@Autowired
	private SafeHospitalMapper safeHospitalMapper;
	
	@Override
	public List<SafehospitalDTO> getShList() throws Exception {
		return safeHospitalMapper.selectSafehospital();
	}
	
	@Override
	public List<SafehospitalDTO> getShListByCityAndGu(String sido_name, String gugun_name) throws Exception {
		return safeHospitalMapper.selectSafehospitalByCityandGu(sido_name.substring(0,2), gugun_name);
	}
}
