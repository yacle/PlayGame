package com.playgame.service;

import com.playgame.domain.MemberVO;

public interface MemberService {
	public void regist(MemberVO vo)throws Exception;
	public MemberVO read(MemberVO vo)throws Exception;
	public void update(MemberVO vo)throws Exception;
	public void delete(MemberVO vo)throws Exception;
	public MemberVO checkId(String id) throws Exception;
}
