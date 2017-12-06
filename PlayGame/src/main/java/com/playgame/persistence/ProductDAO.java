package com.playgame.persistence;

import java.util.List;

import com.playgame.domain.ProductVO;

public interface ProductDAO {
	public void create(ProductVO vo)throws Exception;
	public List<ProductVO> category(String category)throws Exception;
	public ProductVO read(String no)throws Exception;
	public void update(ProductVO vo)throws Exception;
	public void delete(String no)throws Exception;
}
