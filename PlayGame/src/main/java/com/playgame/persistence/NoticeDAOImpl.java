package com.playgame.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.playgame.domain.NoticeVO;
@Repository
public class NoticeDAOImpl implements NoticeDAO {
	@Inject
	private  SqlSessionTemplate session;
	@Override
	public void create(NoticeVO vo) throws Exception {
		session.insert("notice.create", vo);
	}

	@Override
	public NoticeVO read(String no) throws Exception {
		return session.selectOne("notice.read", no);
	}
	
	@Override
	public List<NoticeVO> readList() throws Exception {
		return session.selectList("notice.readList");
	}
	
	@Override
	public void update(NoticeVO vo) throws Exception {
		session.update("notice.update", vo);		
	}

	@Override
	public void delete(String no) throws Exception {
		session.delete("notice.delete", no);
	}

	@Override
	public void addFiles(NoticeVO vo) throws Exception {
		session.insert("notice.addFiles", vo);
		
	}

	@Override
	public List<String> getFiles(String no) throws Exception {
		return session.selectList("notice.getFiles", no);
	}



}
