package com.playgame.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.playgame.domain.MemberVO;
import com.playgame.service.MemberService;

@Controller
public class HomeController {

	@Inject
	MemberService service;
	
	// GET home
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGET()throws Exception{
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "home");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGET()throws Exception{
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "login");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session, HttpServletResponse response)throws Exception{
		MemberVO rvo = service.read(vo);
		if(rvo != null) {
			session.setAttribute("auth_id", vo.getId());
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
}
