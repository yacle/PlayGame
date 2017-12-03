package com.playgame.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playgame.domain.NoticeVO;
import com.playgame.persistence.NoticeDAO;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{
	
	@Inject 
	NoticeDAO dao;

	@Override
	public void regist(NoticeVO vo) throws Exception {
		dao.create(vo);
		String[] files = vo.getFile_url();
		if(files != null){
			for(String file : files){
				vo.setFileName(file);
				dao.addFiles(vo);
			}
		}
	}

	@Override
	public Map read(String no) throws Exception {
		NoticeVO vo = dao.read(no);
		List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();
		for(String val : dao.getFiles(no)) {
			String keyVal = val.substring(val.indexOf("_") + 1);
			Map<String, String> fileMap = new HashMap<String, String>();
			fileMap.put(keyVal, val);
			fileList.add(fileMap);
		}
		Map map = new HashMap();
		map.put("vo", vo);
		map.put("list", fileList);
		return map;
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
