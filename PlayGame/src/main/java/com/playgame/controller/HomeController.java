package com.playgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

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
}
