package com.winter.app.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BoardDAOTest {

	@Autowired
	private BoardDAO boardDAO;
	
	void testDetail() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(3L);
		
		boardDAO.detail(boardDTO);
		log.info(boardDTO.toString());
		
		assertNotNull(boardDTO,"not null");
	}
	
	void testCreate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setTitle("titititle");
		boardDTO.setContents("cocontents");
		boardDTO.setWriter("wriwriter");
		
		boardDAO.create(boardDTO);
		log.info(boardDTO + "이잉");
		assertNotNull(boardDTO,"not null");
	}

	void testDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(94L);
		int result = boardDAO.delete(boardDTO);
		assertEquals(1, result);
		System.out.println("삭제성공" + result);
	}
	void testList() throws Exception {
		List<BoardDTO> ar = boardDAO.list();
		assertNotEquals(0, ar.size());
		System.out.println(ar);
	}

	@Test
	void testUpdate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(110L);
		boardDTO.setTitle("야");
		boardDTO.setContents("호");
		int result = boardDAO.update(boardDTO);
		assertEquals(1, result);
		System.out.println("asdads"+result);
		
	}
	
	
}
