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
 * 로그인 컨트롤러
 */
@RestController
@RequestMapping("/indicate")
public class IndicateController{
	@Autowired
    private IndicateService indicateService;
    
    @GetMapping("/{dong}")
    public ResponseEntity<?> indacateDong(@PathVariable(name="dong")String dong){
    	try {
    		System.out.println("요청");
    		System.out.println(dong);
			return new ResponseEntity<>(indicateService.getIndicateParams(dong),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
    }
}
