package com.playgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/master")
public class MasterController {

	@RequestMapping(value="/notice", method = RequestMethod.GET)
	public ModelAndView noticeHandle() {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/notice");
		return mav;
	}
	
	@RequestMapping(value="/write_notice", method = RequestMethod.GET)
	public ModelAndView write_noticeGETHandle() {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/write_notice");
		return mav;
	}
	
	@RequestMapping(value="/write_notice", method = RequestMethod.POST)
	public String write_noticePOSTHandle() {
		return "redirect:/master/notice";
	}
}
