package com.playgame.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.playgame.domain.MemberVO;
import com.playgame.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public void regist(MemberVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		return dao.read(vo);
	}

	@Override
	public int update(MemberVO vo) throws Exception {
		return dao.update(vo);
	}
	
	@Override
	public int delete(MemberVO vo) throws Exception {
		return dao.delete(vo);
	}
}
