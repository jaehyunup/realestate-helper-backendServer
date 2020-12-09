package com.ssafy.happyhouse.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.notice.dto.NoticeDto;
import com.ssafy.happyhouse.notice.service.NoticeService;


/**
* @className   : NoticeController
* @author 	   : parkjaehyun
* @description : 공지사항 관련 기능 제공 컨트롤러
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-03       parkjaehyun     최초생성
*/
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService service;

	@PostMapping("/insert")
	public String noticeFormConfirm(Model model, NoticeDto notice) {
		/**
		 * @methodName  : noticeFormConfirm
		 * @params      : [model, notice]
		 * @return      : java.lang.String
		 * @description : JSP기반 관리자페이지의 공지사항 쓰기 요청
		 *
		 */
		try {
			service.newNotice(notice);
			model.addAttribute("msg", "공지사항이 등록되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 등록시 에러가 발생하였습니다.");
			return "error/error";
		}
		return "redirect:/adminPage";
	}


	
	@PostMapping("/updateNotify")
	public String update(NoticeDto notice, Model model) throws Exception {
		/**
		 * @methodName  : update
		 * @params      : [notice, model]
		 * @return      : java.lang.String
		 * @description : JSP 기반 관리자페이지의 공지사항 수정 요청
		 *
		 */
		System.out.println(notice.toString());
		service.renameNotice(notice);
		model.addAttribute("msg", "공지사항이 수정되었습니다.");
		return "redirect:/notice/notify";
	}

	@GetMapping("/deleteNotify")
	public String delete(String number) throws Exception {
		/**
		 * @methodName  : delete
		 * @params      : [number]
		 * @return      : java.lang.String
		 * @description : JSP기반 관리자 페이지의 공지사항 삭제 요청
		 *
		 */
		service.deleteNotice(number);
		return "redirect:/notice/notify";
	}


	@GetMapping
	@ResponseBody
	@RequestMapping("/all")
	public ResponseEntity<?>  getNoticeList() throws Exception {
		/**
		 * @methodName  : getNoticeList
		 * @params      : []
		 * @return      : org.springframework.http.ResponseEntity<?>
		 * @description : 일반 사용자 공지사항 조회 (REST)
		 *
		 */
		try {
			return new ResponseEntity<>(service.getNoticesList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	/*공지사항 조회(번호)*/
	@Deprecated
	public void listByNumber(Model model, String number) throws Exception {
		/**
		 * @methodName  : listByNumber
		 * @params      : [model, number]
		 * @return      : void
		 * @description : 관리자의 공지사항 번호 기준 검색 (기능삭제)
		 *
		 */
		model.addAttribute("notice", service.getNoticesListByNumber(number));
	}
	
	/*공지사항 조회(제목)*/
	@Deprecated
	public void listByTitle(Model model, String title) throws Exception {
		/**
		 * @methodName  : listByTitle
		 * @params      : [model, title]
		 * @return      : void
		 * @description : 관리자의 공지사항 이름 기준 검색 (기능삭제)
		 *
		 */
		model.addAttribute("notice", service.getNoticesListByTitle(title));
	}
	
	/*공지사항 조회(내용)*/
	@Deprecated
	public void listByDescrib(Model model, String describ) throws Exception {
		/**
		 * @methodName  : listByDescrib
		 * @params      : [model, describ]
		 * @return      : void
		 * @description :관리자의 공지사항 내용기준 조회 (기능삭제)
		 *
		 */
		model.addAttribute("notice", service.getNoticesListByDescrib(describ));
	}

}
