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
 * 로그인 컨트롤러
 */

@RestController
public class dealController{
	@Autowired
	private DealService service;
	
    @GetMapping("/deal")
    public String dealPage() {
    	return "deal/deal";
    }
    @GetMapping("/deal/top20/{dong}")
    public ResponseEntity<?> dealTop20(@PathVariable(name="dong")String dong) {
    	try {
    		return new ResponseEntity<>(service.selectTopAptByDong(dong),HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    	}
    }
    
    @ResponseBody
    @GetMapping("/deal/{dong}")
	public ResponseEntity<?> deal(@PathVariable(name="dong")String dong) {
    	System.out.println("발생");
		try {
			return new ResponseEntity<>(service.selectDeals(dong),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
    
    @CrossOrigin
    @ResponseBody
    @GetMapping("/deal/all")
	public ResponseEntity<?> allDeal() {
    	System.out.println("발생");
		try {
			return new ResponseEntity<>(service.selectAllDeals(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

}
