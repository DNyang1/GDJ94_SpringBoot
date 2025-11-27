package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO dao;
	
	public List<QnaDTO> list() throws Exception{
		return dao.list();
	}
	
	public int add(QnaDTO dto) throws Exception{
		return dao.add(dto);
	}
}
