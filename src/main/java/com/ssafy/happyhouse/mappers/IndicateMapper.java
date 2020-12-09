package com.ssafy.happyhouse.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.indicate.dto.IndicateDTO;

@Mapper
public interface IndicateMapper {
	public IndicateDTO selectIndicate(String dong) throws Exception;
}
