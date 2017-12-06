package com.playgame.persistence;

import com.playgame.domain.MemberVO;

public interface MemberDAO {
	public void create(MemberVO vo)throws Exception;
	public MemberVO read(MemberVO vo)throws Exception;
	public int read_id(MemberVO vo)throws Exception;
	public String search_id(MemberVO vo)throws Exception;
	public String search_pw(MemberVO vo)throws Exception;
	public int update(MemberVO vo)throws Exception;
	public int delete(MemberVO vo)throws Exception;
}
