package com.playgame.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.playgame.domain.ProductVO;
import com.playgame.persistence.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService{
	@Inject 
	ProductDAO dao;
	
	@Override
	public void regist(ProductVO vo) throws Exception {
		dao.create(vo);
		
	}
	
	@Override
	public List<ProductVO> category(String category) throws Exception {
		return dao.category(category);
	}

	@Override
	public ProductVO read(String no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(String no) throws Exception {
		dao.delete(no);
	}


}
