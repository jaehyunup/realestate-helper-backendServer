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
 * Clinic 컨트롤러 (ClinicService, HouseMapService 활용한 진료소 조회)
 * @author khyun
 *
 */
@RestController
public class ClinicController {
	@Autowired
    private ClinicService service;
 
	@Autowired
	private HouseMapService mapService;
	
	
	/* 진료소 전체 조회 */
	@GetMapping("/clinic")
	public void lookupClinic(Model model) throws Exception {
		model.addAttribute("", service.getClinicList());
	}
	
	@GetMapping("/clinic/{dong}")
	public ResponseEntity<?> getClinicByCityandGu(@PathVariable(name="dong") String dong) throws Exception {
		SidoGugunCodeDto sgcDto = mapService.getSidogugunByDong(dong);
		try {
			return new ResponseEntity<>(service.getClinicListByCityAndGu(sgcDto.getSidoName(), sgcDto.getGugunName()), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

