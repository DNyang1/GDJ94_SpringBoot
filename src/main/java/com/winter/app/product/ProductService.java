package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
    public List<ProductDTO> list(Pager pager) throws Exception {
        Long totalCount = dao.countList();
        pager.pageing(totalCount);
        return dao.list(pager);
    }

    public ProductDTO detail(ProductDTO dto) throws Exception {
        return dao.detail(dto);
    }

    public int add(ProductDTO dto) throws Exception {
        return dao.add(dto);
    }

    public int update(ProductDTO dto) throws Exception {
        return dao.update(dto);
    }

    public int delete(ProductDTO dto) throws Exception {
        return dao.delete(dto);
    }
}
