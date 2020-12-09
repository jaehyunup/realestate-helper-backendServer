package com.ssafy.happyhouse.deal.service;

import java.util.List;

import com.ssafy.happyhouse.deal.dto.DealDTO;

public interface DealService {
	public List<DealDTO> selectDeals(String dong) throws Exception;
	public List<DealDTO> selectAllDeals() throws Exception;
	public List<DealDTO> selectBookmarkDeal(String userId) throws Exception;
	public List<DealDTO> selectTopAptByDong(String dong) throws Exception;

}
