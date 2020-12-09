package com.ssafy.happyhouse.deal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.deal.service.DealService;

/**
* @className   : dealController
* @author 	   : parkjaehyun
* @description : 아파트 거래 관련 기능 제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-13       parkjaehyun     최초생성
*/
@RestController
public class dealController{
	@Autowired
	private DealService service;

    @GetMapping("/deal/all")
	public ResponseEntity<?> allDeal() {
    	/**
    	 * @methodName  : allDeal
    	 * @params      : []
    	 * @return      : org.springframework.http.ResponseEntity<?>
    	 * @description : 전국 아파트 거래내역을 전체 조회
    	 *
    	 */
		try {
			return new ResponseEntity<>(service.selectAllDeals(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/deal/{dong}")
	public ResponseEntity<?> deal(@PathVariable(name="dong")String dong) {
		/**
		 * @methodName  : deal
		 * @params      : [dong]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 해당 법정동 내 모든 아파트 거래내역을 조회
		 *
		 */
		try {
			return new ResponseEntity<>(service.selectDeals(dong),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/deal/top20/{dong}")
	public ResponseEntity<?> dealTop20(@PathVariable(name="dong")String dong) {
		/**
		 * @methodName  : dealTop20
		 * @params      : [dong]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 해당 법정동 내 가격기준 상위 20개 아파트 조회
		 *
		 */
		try {
			return new ResponseEntity<>(service.selectTopAptByDong(dong),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}

}
