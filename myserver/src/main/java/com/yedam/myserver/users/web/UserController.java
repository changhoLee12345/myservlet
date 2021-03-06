package com.yedam.myserver.users.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.users.mapper.UserMapper;
import com.yedam.myserver.users.vo.UserVO;

@CrossOrigin(origins = { "http://127.0.0.1:3000" }, maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	UserMapper mapper;

	// 전체조회
	@GetMapping(value = "/userSelectAll")
	@ResponseBody
	public List<UserVO> userSelect() {
		return mapper.find();
	}

	// 단건조회
	@GetMapping("/userSelect")
	@ResponseBody
	public UserVO userSelectList(UserVO vo) {
		System.out.println(vo);
		return mapper.findById(vo);
	}

	// 삭제
	@GetMapping("/userDelete")
	public UserVO userDelete(UserVO vo) {
		mapper.remove(vo);
		return vo;
	}

	// 등록
	@PostMapping("/userInsert")
	public UserVO userInsert(@RequestBody UserVO vo) {
		System.out.println(vo);
		mapper.persist(vo);
		return vo;
	}

	// 수정
	@PostMapping("/userUpdate")
	public UserVO userUpdate(UserVO vo) {
		System.out.println(vo);
		mapper.merge(vo);
		return vo;
	}

}
