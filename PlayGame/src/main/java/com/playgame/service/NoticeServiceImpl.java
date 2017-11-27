package com.playgame.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.playgame.domain.NoticeVO;
import com.playgame.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject 
	NoticeDAO dao;

	@Override
	public void regist(NoticeVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public NoticeVO read(String no) throws Exception {
		return dao.read(no);
	}

	@Override
	public List<NoticeVO> readList() throws Exception {
		return dao.readList();
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(String no) throws Exception {
		dao.delete(no);
	}

}
