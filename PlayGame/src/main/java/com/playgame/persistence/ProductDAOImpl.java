package com.playgame.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.playgame.domain.ProductVO;
@Repository
public class ProductDAOImpl implements ProductDAO{
	@Inject
	private  SqlSessionTemplate session;
	@Override
	public void create(ProductVO vo) throws Exception {
		session.insert("product.create", vo);
	}
	
	@Override
	public List<ProductVO> category(String category) throws Exception {
		return session.selectList("product.category", category);
	}

	@Override
	public ProductVO read(String no) throws Exception {
		return session.selectOne("product.readOne", no);
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		session.update("product.update", vo);
	}

	@Override
	public void delete(String no) throws Exception {
		session.delete("product.delete", no);
	}


}
