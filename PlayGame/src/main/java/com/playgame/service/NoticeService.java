package com.playgame.service;

import java.util.List;
import java.util.Map;

import com.playgame.domain.NoticeVO;

public interface NoticeService {
	public void regist(NoticeVO vo)throws Exception;
	public Map read(String no)throws Exception;
	public List<NoticeVO> readList()throws Exception;
	public void update(NoticeVO vo)throws Exception;
	public void delete(String no)throws Exception;
}
