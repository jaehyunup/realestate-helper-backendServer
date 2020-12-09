package com.ssafy.happyhouse.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.notice.dto.NoticeDto;
import com.ssafy.happyhouse.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	/*공지사항 등록*/
	@GetMapping("/insertNotify")
	public void addNoticeForm() {}
	@PostMapping("/insertNotify")
	public String add(Model model, NoticeDto notice) {
		try {
			service.newNotice(notice);
			model.addAttribute("msg", "공지사항이 등록되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 등록시 에러가 발생하였습니다.");
			return "error/error";
		}
		return "redirect:/notice/notify";
	}

	
	
	/*공지사항 수정*/
	@GetMapping("/updateNotify")
	public String updateNoticeForm(String number, Model model) throws Exception {
		model.addAttribute("noticeVO", service.getNoticesListByNumber(number));
		System.out.println(number);
		System.out.println(model.toString());
		return "notice/updateNotify";
	}
	
	@PostMapping("/updateNotify")
	public String update(NoticeDto notice, Model model) throws Exception {
		System.out.println(notice.toString());
		service.renameNotice(notice);
		model.addAttribute("msg", "공지사항이 수정되었습니다.");
		return "redirect:/notice/notify";
	}
	
	/*공지사항 삭제*/
	@GetMapping("/deleteNotify")
	public String delete(String number) throws Exception {
		service.deleteNotice(number);
		return "redirect:/notice/notify";
	}
	
	/*공지사항 조회*/
	@GetMapping
	@RequestMapping("/notify")
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.getNoticesList());
	}
	
	/*공지사항 조회(번호)*/
	public void listByNumber(Model model, String number) throws Exception {
		model.addAttribute("notice", service.getNoticesListByNumber(number));
	}
	
	/*공지사항 조회(제목)*/
	public void listByTitle(Model model, String title) throws Exception {
		model.addAttribute("notice", service.getNoticesListByTitle(title));
	}
	
	/*공지사항 조회(내용)*/
	public void listByDescrib(Model model, String describ) throws Exception {
		model.addAttribute("notice", service.getNoticesListByDescrib(describ));
	}

}
