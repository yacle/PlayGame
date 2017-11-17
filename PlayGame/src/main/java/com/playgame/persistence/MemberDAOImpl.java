package com.playgame.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;

import com.playgame.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO{
@Inject
private  SqlSessionTemplate session;
	
	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
