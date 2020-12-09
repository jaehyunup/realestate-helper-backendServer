package com.ssafy.happyhouse.map.controller;


import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.map.service.HouseMapService;

/**
* @className   : LocationController
* @author 	   : parkjaehyun
* @description : 법정동,시도군구 등 지역구 관련 기능 제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-10-24       parkjaehyun     최초생성
*/
@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private HouseMapService houseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<?> sido() throws ServletException, IOException {
		/**
		 * @methodName  : sido
		 * @params      : []
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 국내 모든 시/도를 조회한다
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getSido(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<?> gugun(String sido) throws ServletException, IOException {
		/**
		 * @methodName  : gugun
		 * @params      : [sido]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 시/도(파라미터)에 속해있는 군/구를 모두 반환한다.
		 *
		 */
		try {
			 return new ResponseEntity<>(houseMapService.getGugunInSido(sido),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/dong")
	public ResponseEntity<?> dong(String gugun) throws ServletException, IOException {
		/**
		 * @methodName  : dong
		 * @params      : [gugun]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 군/구 에 속해있는 모든 동을 반환한다
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getDongInGugun(gugun),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/gugun/{dong}")
	public ResponseEntity<?> gugunCodeByDong(@PathVariable(name="dong")String dong) throws ServletException, IOException {
		/**
		 * @methodName  : gugunCodeByDong
		 * @params      : [dong]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 법정동이 속한 시도군구를 조회한다
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getSidogugunByDong(dong),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/apt")
	public ResponseEntity<?> apt(Map<String,Object> list) throws ServletException, IOException {
		/**
		 * @methodName  : apt
		 * @params      : [list]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 법정동내 아파트를 모두 조회한다.
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getAptInDong((String) list.get("dong")),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/area/{dong}/{AptName}")
	public ResponseEntity<?> getAreaByDongAndAptName(@PathVariable(name="dong")String dong,@PathVariable(name="AptName")String AptName) throws ServletException, IOException {
		/**
		 * @methodName  : getAreaByDongAndAptName
		 * @params      : [dong, AptName]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 해당 아파트에 존재하는 모든 평수(전용면적)를 반환한다
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getAreaByDongAndAptName(dong, AptName),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/area/{dong}/{AptName}/{area}")
	public ResponseEntity<?> getAmountHistory(@PathVariable(name="dong")String dong,@PathVariable(name="AptName")String AptName,@PathVariable(name="area")String area) throws ServletException, IOException {
		/**
		 * @methodName  : getAmountHistory
		 * @params      : [dong, AptName, area]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 해당 아파트의 거래 기록 조회
		 *
		 */
		try {
			return new ResponseEntity<>(houseMapService.getAmountHistory(dong, AptName, area),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	

	
}
