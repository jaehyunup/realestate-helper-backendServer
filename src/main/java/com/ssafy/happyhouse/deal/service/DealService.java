package com.ssafy.happyhouse.deal.service;

import java.util.List;

import com.ssafy.happyhouse.deal.dto.DealDTO;

/**
* @className   : DealService
* @author 	   : parkjaehyun
* @description : 아파트 거래 기능 비즈니스로직 추상화 인터페이스
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-13       parkjaehyun     최초생성
*/
public interface DealService {
	public List<DealDTO> selectDeals(String dong) throws Exception;
	public List<DealDTO> selectAllDeals() throws Exception;
	public List<DealDTO> selectBookmarkDeal(String userId) throws Exception;
	public List<DealDTO> selectTopAptByDong(String dong) throws Exception;

}
