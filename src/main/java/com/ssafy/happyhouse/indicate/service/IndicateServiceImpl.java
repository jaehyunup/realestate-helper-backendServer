package com.ssafy.happyhouse.indicate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.indicate.dto.IndicateDTO;
import com.ssafy.happyhouse.mappers.IndicateMapper;
@Service
public class IndicateServiceImpl implements IndicateService {
	@Autowired
	private IndicateMapper indicateMapper;
	

	@Override
	public IndicateDTO getIndicateParams(String dong) throws Exception {
		return indicateMapper.selectIndicate(dong.substring(0,dong.length()-1));
	}
}
