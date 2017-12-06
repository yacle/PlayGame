package com.playgame.service;

import java.util.List;

import com.playgame.domain.ProductVO;

public interface ProductService {
	public void regist(ProductVO vo)throws Exception;
	public List<ProductVO> category(String category)throws Exception;
	public ProductVO read(String no)throws Exception;
	public void update(ProductVO vo)throws Exception;
	public void delete(String no)throws Exception;
}
