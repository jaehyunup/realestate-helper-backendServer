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
 * 로그인 컨트롤러
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
    	try {
    		SidoGugunCodeDto sidogugun=mapService.getSidogugunByDong(dong);
    		System.out.println(sidogugun);
			return new ResponseEntity<>(safetyHospitalService.getShListByCityAndGu(sidogugun.getSidoName(),sidogugun.getGugunName()),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
    }
}
