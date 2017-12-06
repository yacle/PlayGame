package com.playgame.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.playgame.domain.NoticeVO;
import com.playgame.service.NoticeService;

@Controller
@RequestMapping("/master")
public class MasterController {

	@RequestMapping("/manage")
	public ModelAndView manageHandle() {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/manage");
		return mav;
	}
	
	@RequestMapping("order")
	public ModelAndView orderHandle() {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/order");
		return mav;
	}
}
