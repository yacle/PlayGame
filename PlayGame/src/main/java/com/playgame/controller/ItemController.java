package com.playgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/item")
public class ItemController {

	@RequestMapping("/item_list/{category}")
	public ModelAndView item_listHandle(@PathVariable String category) {
		ModelAndView mav = new ModelAndView("temp");
		
		mav.addObject("section", "item/item_list");
		return mav;
	}
	
	@RequestMapping("/view/{no}")
	public ModelAndView view_itemHandle(@PathVariable String no) {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "item/view_item");
		return mav;
	}
}
