package com.ssafy.happyhouse.attention.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.attention.dto.AttentionDTO;
import com.ssafy.happyhouse.attention.dto.Bookmark;
import com.ssafy.happyhouse.attention.service.AttentionService;
import com.ssafy.happyhouse.deal.service.DealService;

@RestController
@RequestMapping("/attention")
public class AttentionController{
	@Autowired
	private AttentionService service;
	@Autowired
	private DealService dealservice;
	/**
	 *
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 유저정보 기반으로 관심지역을 조회 (업데이트중 기능 삭제로 인해 deprecated)
	 * @deprecated
	 */
	@GetMapping("/list")
	public ResponseEntity<?> getAttention(HttpSession session) throws ServletException, IOException {
		AttentionDTO inputDto=new AttentionDTO();
		String user_id=(String)session.getAttribute("user_id");
		inputDto.setUser_id(user_id);
		try {
			return new ResponseEntity<>(service.selectAttention(inputDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @param map
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 유저정보 기반으로 관심지역을 추가 (업데이트중 기능 삭제로 인해 deprecated)
	 */
	@ResponseBody
	@PutMapping
	public ResponseEntity<?> putAttention(@RequestParam Map<String,Object> map) throws ServletException, IOException {
		AttentionDTO inputDto=new AttentionDTO();
		String user_id=(String)map.get("user_id");
		String dong=(String)map.get("dong");
		inputDto.setUser_id(user_id);
		inputDto.setDong(dong);
		try {
			List<AttentionDTO> attentionedList=service.selectAttention(inputDto);
			boolean flag=false;
			for (int i = 0; i < attentionedList.size(); i++) {
				if(attentionedList.get(i).getUser_id().equals(user_id)
						&& attentionedList.get(i).getDong().equals(dong)) {
					flag=true;
				}
			}
			if(flag==false) {
				return new ResponseEntity<>(service.insertAttention(inputDto), HttpStatus.OK);
			}else {
				// 중복된 즐겨찾기 요청이라면
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @param map
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 유저정보 기반으로 관심지역을 삭제 (업데이트중 기능 삭제로 인해 deprecated)
	 */
	@DeleteMapping
	public ResponseEntity<?> deleteAttention(Map<String,Object> map) throws ServletException, IOException {
		AttentionDTO inputDto=new AttentionDTO();
		String user_id=(String)map.get("user_id");
		String dong=(String)map.get("dong");
		inputDto.setUser_id(user_id);
		inputDto.setDong(dong);
		try {
			List<AttentionDTO> attentionedList=service.selectAttention(inputDto);
			boolean flag=false;
			for (int i = 0; i < attentionedList.size(); i++) {
				if(attentionedList.get(i).getUser_id().equals(user_id)
						&& attentionedList.get(i).getDong().equals(dong)) {
					flag=true;
				}
				
			}
			if(flag==false) {
				// 없는것을 요청시
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}else {
				//  있는것을 삭제요청시
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 관심매물 조회
	 */
	@GetMapping("/bookmark/{userId}")
	public ResponseEntity<?> getBookmark(@PathVariable(name="userId")String userId) throws ServletException, IOException {
		try {
			return new ResponseEntity<>(dealservice.selectBookmarkDeal(userId), HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	}

	/**
	 *
	 * @param userId
	 * @param no
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 관심매물 추가 가능 여부 확인
	 */
	@GetMapping("/bookmark/{userId}/{no}")
	public ResponseEntity<?> bootmarkallow(@PathVariable(name="userId")String userId,@PathVariable(name="no")int no) throws ServletException, IOException {
		try {
			int status=service.selectBookmark(userId, no).size();
			if(status>0) { // 중복
				return new ResponseEntity<>("notAllow", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Allow", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("error", HttpStatus.CONFLICT);
	}

	/**
	 * @param userId
	 * @param no
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 관심매물 추가
	 */
	@PostMapping("/bookmark/{userId}/{no}")
	public ResponseEntity<?> Addbookmark(@PathVariable(name="userId")String userId,@PathVariable(name="no")int no) throws ServletException, IOException {
		System.out.println(userId+" "+no);
		try {
			return new ResponseEntity<>(service.insertBookmark(userId, no)>0?"true":"false", HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	}

	/**
	 *
	 * @param userId
	 * @param no
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @decription 관심매물 삭제
	 */
	@DeleteMapping("/bookmark/{userId}/{no}")
	public ResponseEntity<?> deletebookmark(@PathVariable(name="userId")String userId,@PathVariable(name="no")int no) throws ServletException, IOException {

		try {
			return new ResponseEntity<>(service.deleteBookmark(userId, no)>0?"true":"false", HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	}
}