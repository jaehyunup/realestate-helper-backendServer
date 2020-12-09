package com.ssafy.happyhouse.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 관리자페이지 접속 컨트롤러
 */
@Controller
public class adminController{
	@GetMapping("/adminPage")
	public String adminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "admin/adminPage";
	}
	
	@GetMapping("/updatePage")
	public String updatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "admin/updatePage";
	}
	
	@GetMapping("/searchPage")
	public String searchPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "admin/searchPage";
	}

}
