package com.playgame.persistence;

import com.playgame.domain.MemberVO;

public interface MemberDAO {
	public void create(MemberVO vo)throws Exception;
	public MemberVO read(MemberVO vo)throws Exception;
	public void update(MemberVO vo)throws Exception;
	public void delete(MemberVO vo)throws Exception;
}
