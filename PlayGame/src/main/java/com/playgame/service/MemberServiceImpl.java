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
	public void update(MemberVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(MemberVO vo) throws Exception {
		dao.delete(vo);
	}

}
