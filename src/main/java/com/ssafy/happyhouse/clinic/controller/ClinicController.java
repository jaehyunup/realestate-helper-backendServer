package com.ssafy.happyhouse.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.clinic.service.ClinicService;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.map.service.HouseMapService;

/**
* @className   : ClinicController
* @author 	   : parkjaehyun
* @description : 안심병원기능제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-08       parkjaehyun     최초생성
*/
@RestController
public class ClinicController {
	@Autowired
    private ClinicService service;
	@Autowired
	private HouseMapService mapService;


	@GetMapping("/clinic/{dong}")
	public ResponseEntity<?> getClinicByCityandGu(@PathVariable(name="dong") String dong) throws Exception {
		/**
		 * @methodName  : getClinicByCityandGu
		 * @params      : [dong]
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 법정동 기준 모든 안심병원 리스트 조회
		 *
		 */
		SidoGugunCodeDto sgcDto = mapService.getSidogugunByDong(dong);
		try {
			return new ResponseEntity<>(service.getClinicListByCityAndGu(sgcDto.getSidoName(), sgcDto.getGugunName()), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

