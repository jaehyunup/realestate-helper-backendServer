package com.ssafy.happyhouse.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.clinic.dto.ClinicDTO;
import com.ssafy.happyhouse.mappers.ClinicMapper;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicMapper clinicMapper;
	
	
	@Override
	public List<ClinicDTO> getClinicList() throws Exception {
		return clinicMapper.selectClinic();
	}
	
	@Override
	public List<ClinicDTO> getClinicListByCityAndGu(String sido_name, String gugun_name) throws Exception {
		return clinicMapper.selectClinicByCityandGu(sido_name.substring(0,2), gugun_name);
	}
}
