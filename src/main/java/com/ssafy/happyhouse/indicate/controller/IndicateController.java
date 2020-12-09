package com.ssafy.happyhouse.indicate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.indicate.service.IndicateService;
import com.ssafy.happyhouse.map.dto.SidoGugunCodeDto;

/**
* @className   : IndicateController
* @author 	   : parkjaehyun
* @description : 법정동기준 시도군구 코드 반환 기능 컨트롤러 (공공데이터포탈의 법정동 코드가 API마다 다른 이슈에 대응)
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-20       parkjaehyun     최초생성
*/
@RestController
@RequestMapping("/indicate")
public class IndicateController{
	@Autowired
    private IndicateService indicateService;
    
    @GetMapping("/{dong}")
    public ResponseEntity<?> indacateDong(@PathVariable(name="dong")String dong){
    	/**
    	 * @methodName  : indacateDong
    	 * @params      : [dong]
    	 * @return      : org.springframework.http.ResponseEntity<?>
    	 * @description : 법정동기준 시도군구 코드를 반환한다.
    	 *
    	 */
    	try {
			return new ResponseEntity<>(indicateService.getIndicateParams(dong),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
    }
}
