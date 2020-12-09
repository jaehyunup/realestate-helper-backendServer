package com.ssafy.happyhouse.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.deal.dto.DealDTO;
import com.ssafy.happyhouse.mappers.DealMapper;
/**
* @className   : DealServiceImpl
* @author 	   : parkjaehyun
* @description : 아파트 거래 관련 비즈니스로직 구현계층
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-13       parkjaehyun     최초생성
*/
@Service
public class DealServiceImpl implements DealService{
	@Autowired
	private DealMapper dealMapper;

	@Override
	public List<DealDTO> selectAllDeals() throws Exception {
		/**
		 * @methodName  : selectAllDeals
		 * @params      : []
		 * @return      : java.util.List<com.ssafy.happyhouse.deal.dto.DealDTO>
		 * @description : 모든 아파트거래 조회
		 *
		 */
		return dealMapper.selectAllDeals();
	}

	@Override
	public List<DealDTO> selectDeals(String dong) throws Exception {
		/**
		 * @methodName  : selectDeals
		 * @params      : [dong]
		 * @return      : java.util.List<com.ssafy.happyhouse.deal.dto.DealDTO>
		 * @description : 법정동 기준 아파트거래 모두 조회
		 *
		 */
		return dealMapper.selectDeals(dong);
	}

	@Override
	public List<DealDTO> selectBookmarkDeal(String userId) throws Exception {
		/**
		 * @methodName  : selectBookmarkDeal
		 * @params      : [userId]
		 * @return      : java.util.List<com.ssafy.happyhouse.deal.dto.DealDTO>
		 * @description : 내 관심 아파트 거래 조회
		 *
		 */
		return dealMapper.selectBookmarkDeal(userId);
	}

	@Override
	public List<DealDTO> selectTopAptByDong(String dong) throws Exception {
		/**
		 * @methodName  : selectTopAptByDong
		 * @params      : [dong]
		 * @return      : java.util.List<com.ssafy.happyhouse.deal.dto.DealDTO>
		 * @description : 법정동내 가장 비싼 거래를 기록한 20개 아파트를 조회
		 *
		 */
		return dealMapper.selectTopAptByDong(dong);
	}
	
	

}
