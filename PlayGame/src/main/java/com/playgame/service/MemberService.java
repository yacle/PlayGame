package com.playgame.service;

import com.playgame.domain.MemberVO;

public interface MemberService {
	public void regist(MemberVO vo)throws Exception;
	public MemberVO read(MemberVO vo)throws Exception;
	public int update(MemberVO vo)throws Exception;
	public int delete(MemberVO vo)throws Exception;
}
