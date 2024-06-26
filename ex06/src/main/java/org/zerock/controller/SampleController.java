package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access ");
	}

	@GetMapping("/member")
	public void doMember() {
		log.info("do member can access");
	}

	@GetMapping("/admin")
	public void doAdmin() {
		log.info("do admin can access");
	}

}
