package com.winter.app.board.notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.util.Pager;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO dao;
	
	
	void testDetail() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		dto.setBoardNum(1L);
		dao.detail(dto);
		System.out.println(dto);
	}
	
	void testList() throws Exception {
		List<NoticeDTO> ar = dao.list(null);
		System.out.println(ar);
	}
	
	@Test
	void testAdd() throws Exception {
		for (int i = 0; i < 120; i++) {
			NoticeDTO dto = new NoticeDTO();
			dto.setBoardTitle("햄"+i);
			dto.setBoardWriter("버"+i);
			dto.setBoardContents("거"+i);
			System.out.println(dao.add(dto));
		}
	}
	
	void testUpdate() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		dto.setBoardNum(8L);
		dto.setBoardTitle("김현진의");
		dto.setBoardWriter("모든반지");
		dto.setBoardContents("삭제기원");
		System.out.println(dao.update(dto));
	}
	
	void testDelete() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		dto.setBoardNum(4L);
		System.out.println(dao.delete(dto));
	}
}
