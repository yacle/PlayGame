package com.playgame.persistence;

import java.util.List;

import com.playgame.domain.NoticeVO;

public interface NoticeDAO {
	public void create(NoticeVO vo)throws Exception;
	public NoticeVO read(String no)throws Exception;
	public List<NoticeVO> readList()throws Exception;
	public void update(NoticeVO vo)throws Exception;
	public void delete(String no)throws Exception;
}
