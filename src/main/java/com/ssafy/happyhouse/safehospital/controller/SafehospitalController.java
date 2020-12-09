package com.ssafy.happyhouse.safehospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.map.service.HouseMapService;
import com.ssafy.happyhouse.safehospital.service.SafehospitalService;


/**
* @className   : SafehospitalController
* @author 	   : parkjaehyun
* @description : 안심보건소 기능제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-14       parkjaehyun     최초생성
*/
@RestController
@RequestMapping("/safetyhospital")
public class SafehospitalController{
	@Autowired
    private SafehospitalService safetyHospitalService;
    @Autowired
    private HouseMapService mapService;
    
    @GetMapping("/{dong}")
    public ResponseEntity<?> SafetyHospital(@PathVariable(name="dong")String dong){
    	/**
    	 * @methodName  : SafetyHospital
    	 * @params      : [dong]
    	 * @return      : org.springframework.http.ResponseEntity<?>
    	 * @description : 해당 법정동의 안심보건소를 반환한다
    	 *
    	 */
    	try {
    		SidoGugunCodeDto sidogugun=mapService.getSidogugunByDong(dong);
    		System.out.println(sidogugun);
			return new ResponseEntity<>(safetyHospitalService.getShListByCityAndGu(sidogugun.getSidoName(),sidogugun.getGugunName()),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
    }
}
