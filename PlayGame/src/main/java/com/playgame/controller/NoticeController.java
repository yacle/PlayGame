package com.playgame.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.playgame.domain.NoticeVO;
import com.playgame.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
@Inject 
NoticeService service;

	@RequestMapping(value = "/write_notice", method = RequestMethod.GET)
	public ModelAndView createNoticeGETHandle() {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/write_notice");
		return mav;
	}
	
	@RequestMapping(value = "/write_notice", method = RequestMethod.POST)
	public String createNoticePOSTHandle(NoticeVO vo) throws Exception {
		service.regist(vo);
		return "redirect:/master/notice";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView noticeListHandle() throws Exception{
		List<NoticeVO> list = service.readList();
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/notice");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/view/{no}", method = RequestMethod.GET)
	public ModelAndView viewNoticeHandle(@PathVariable String no) throws Exception {
//		NoticeVO vo = service.read(no);
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "master/view_notice");
//		mav.addObject("list", vo);
		return mav;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public void updateNoticeHandle(NoticeVO vo) throws Exception {
		service.update(vo);
	}
	
	@RequestMapping(value = "/delete/{no}")
	public void deleteNoticeHandle(@PathVariable String no) throws Exception {
		service.delete(no);
		
	}
}
