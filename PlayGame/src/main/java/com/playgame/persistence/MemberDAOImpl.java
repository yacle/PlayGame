package com.playgame.persistence;

import javax.inject.Inject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.playgame.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
@Inject
private  SqlSessionTemplate session;
	
	@Override
	public void create(MemberVO vo) throws Exception {
		session.insert("member.create", vo);
	}

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		return session.selectOne("member.read", vo);
	}

	@Override
	public int update(MemberVO vo) throws Exception {
		return session.update("member.update", vo);
	}

	@Override
	public int delete(MemberVO vo) throws Exception {
		return session.delete("member.delete", vo);
	}
}
