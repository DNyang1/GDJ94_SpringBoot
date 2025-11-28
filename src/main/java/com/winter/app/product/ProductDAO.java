package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.util.Pager;

@Mapper
public interface ProductDAO {
	public List<ProductDTO> list(Pager pager) throws Exception; 
	public ProductDTO detail(ProductDTO dto) throws Exception;
    public int add(ProductDTO dto) throws Exception;
    public int update(ProductDTO dto) throws Exception;
    public int delete(ProductDTO dto) throws Exception;
    public Long countList() throws Exception;
}
