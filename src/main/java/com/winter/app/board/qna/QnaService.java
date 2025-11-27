package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;


@Service
public class QnaService {
	
	@Autowired
	private QnaDAO dao;
	
	public List<QnaDTO> list(Pager pager) throws Exception {
		Long totalCount = dao.countList();
		pager.pageing(totalCount);
		return dao.list(pager);
	}
	
	public QnaDTO detail(QnaDTO dto) throws Exception {
		return dao.detail(dto);
	}

	public int add(QnaDTO dto) throws Exception {
		dao.add(dto);
		
		return dao.refUpdate(dto);
	}

	public int update(QnaDTO dto) throws Exception {
		return dao.update(dto);
	}

	public int delete(QnaDTO dto) throws Exception {
		return dao.delete(dto);
	}
}
