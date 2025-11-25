package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO dao;
	
	public List<NoticeDTO> list() throws Exception{
		return dao.list();
	}
	
	public NoticeDTO detail(NoticeDTO dto) throws Exception {
		return dao.detail(dto);
	}
	
	public int insert(NoticeDTO dto) throws Exception {
		return dao.insert(dto);
	}
	
	public int update(NoticeDTO dto) throws Exception {
		return dao.update(dto);
	}
	
	public int delete(NoticeDTO dto) throws Exception {
		return dao.delete(dto);
	}
	
}
