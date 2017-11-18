package com.playgame.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.playgame.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGET()throws Exception{
	}
}
