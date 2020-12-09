package com.ssafy.happyhouse.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.deal.dto.DealDTO;
import com.ssafy.happyhouse.mappers.DealMapper;
@Service
public class DealServiceImpl implements DealService{
	@Autowired
	private DealMapper dealMapper;
	
	@Override
	public List<DealDTO> selectDeals(String dong) throws Exception {
		return dealMapper.selectDeals(dong);
	}

	@Override
	public List<DealDTO> selectAllDeals() throws Exception {
		return dealMapper.selectAllDeals();

	}

	@Override
	public List<DealDTO> selectBookmarkDeal(String userId) throws Exception {
		return dealMapper.selectBookmarkDeal(userId);
	}

	@Override
	public List<DealDTO> selectTopAptByDong(String dong) throws Exception {
		return dealMapper.selectTopAptByDong(dong);
	}
	
	

}
