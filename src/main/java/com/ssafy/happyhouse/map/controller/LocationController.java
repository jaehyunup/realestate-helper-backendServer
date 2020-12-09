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

@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {
	
	@Autowired
	HouseMapService houseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<?> sido() throws ServletException, IOException {
		try {
			System.out.println("시도요청");
			return new ResponseEntity<>(houseMapService.getSido(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<?> gugun(String sido) throws ServletException, IOException {
		try {
			 return new ResponseEntity<>(houseMapService.getGugunInSido(sido),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/dong")
	public ResponseEntity<?> dong(String gugun) throws ServletException, IOException {
		try {
			return new ResponseEntity<>(houseMapService.getDongInGugun(gugun),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/gugun/{dong}")
	public ResponseEntity<?> gugunCodeByDong(@PathVariable(name="dong")String dong) throws ServletException, IOException {
		try {
			houseMapService.getSidogugunByDong(dong);
			return new ResponseEntity<>(houseMapService.getSidogugunByDong(dong),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/apt")
	public ResponseEntity<?> apt(Map<String,Object> list) throws ServletException, IOException {
		String dong = (String) list.get("dong");
		try {
			return new ResponseEntity<>(houseMapService.getAptInDong(dong),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/area/{dong}/{AptName}")
	public ResponseEntity<?> getAreaByDongAndAptName(@PathVariable(name="dong")String dong,@PathVariable(name="AptName")String AptName) throws ServletException, IOException {
		try {
			return new ResponseEntity<>(houseMapService.getAreaByDongAndAptName(dong, AptName),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/area/{dong}/{AptName}/{area}")
	public ResponseEntity<?> getAmountHistory(@PathVariable(name="dong")String dong,@PathVariable(name="AptName")String AptName,@PathVariable(name="area")String area) throws ServletException, IOException {
		
		try {
			return new ResponseEntity<>(houseMapService.getAmountHistory(dong, AptName, area),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	

	
}
