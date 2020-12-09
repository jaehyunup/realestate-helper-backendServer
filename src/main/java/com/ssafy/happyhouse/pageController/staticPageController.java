package com.ssafy.happyhouse.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 홈 컨트롤러
 */
@Controller
public class staticPageController{
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/sitemap")
	public String sitemap() {
		return "sitemap";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/")
	public String index() {
		return "redirect:home";
	}
	


}
