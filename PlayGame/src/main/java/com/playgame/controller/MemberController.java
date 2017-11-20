package com.playgame.controller;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.playgame.domain.MemberVO;
import com.playgame.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	private MemberService service;
	@Inject
	ServletContext application;
	@Inject
	SimpleDateFormat sdf;
	@Inject
	JavaMailSender sender;
	
	// GET join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView joinGET()throws Exception{
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "member/join");
		return mav;
	}
	// POST join
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST()throws Exception{
		return "redirect:/index";
	}
	// ID 중복체크
	@RequestMapping(value="/duplication", method = RequestMethod.POST)
	@ResponseBody
	public String idcheckHandle(@RequestBody Map map) throws Exception {
		MemberVO vo = service.checkId((String)map.get("id"));
		if(vo != null){
			return "ok";
		}else {
			return "no";
		}
	} 
	// Email 인증코드 발송
	@RequestMapping(value="/regEmail", method = RequestMethod.POST)
	@ResponseBody
	public void emailRegSend(@RequestBody Map map, HttpSession session) throws AddressException, MessagingException{
		String email = (String) map.get("email");
		MimeMessage msg = sender.createMimeMessage();
		msg.setRecipient(RecipientType.TO, new InternetAddress(email));
		msg.setSubject("Email 인증코드");
		UUID u = UUID.randomUUID();	
		String code = u.toString().substring(0, 6);
		String text = "인증코드 :"+code;
		msg.setText(text, "UTF-8", "html");
		sender.send(msg);
		session.setAttribute("uuid", code);
	}
	// 인증코드 확인
	@RequestMapping(value="/regCode", method = RequestMethod.POST)
	@ResponseBody
	public String regCodeHandle(@RequestBody Map map, HttpSession session) throws Exception {
		String regCode = (String)map.get("regCode");
		String uuid = (String)session.getAttribute("uuid");
		if(regCode.equals(uuid)) {
			return "true";
		}else {
			return "false";
		}
	}
	// GET 회원탈퇴
	@RequestMapping(value="/withdraw", method = RequestMethod.GET)
	public ModelAndView withdrawGET()throws Exception {
		ModelAndView mav = new ModelAndView("temp");
		mav.addObject("section", "member/withdraw");
		return mav;
	}
	// POST 회원탈퇴
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdrawPOST()throws Exception{
		return "redirect:/index";
	}
}
