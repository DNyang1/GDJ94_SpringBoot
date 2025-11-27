package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.util.Pager;

@Mapper
public interface QnaDAO {
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception;
	public List<QnaDTO> list(Pager pager) throws Exception;
	public int add(QnaDTO dto) throws Exception;
	public int update(QnaDTO qnaDTO) throws Exception;
	public int delete(QnaDTO qnaDTO) throws Exception;
	public Long countList() throws Exception;
	public int refUpdate(QnaDTO qnaDTO) throws Exception;
		
}
