package com.playgame.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.playgame.domain.ProductVO;
import com.playgame.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Inject
	ProductService service;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addProductGET() {
		return "product/product_reg";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public void addProductPOST(ProductVO vo) throws Exception {
		service.regist(vo);
	}

	@RequestMapping("/item_list/{category}")
	public ModelAndView item_listHandle(@PathVariable String category) {
		ModelAndView mav = new ModelAndView("temp");
		
		mav.addObject("section", "product/item_list");
		return mav;
	}
	
	@RequestMapping("/view/{no}")
	public ModelAndView view_itemHandle(@PathVariable String no) {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "product/view_item");
		return mav;
	}
}
