package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

public interface BoardService<T extends BoardDTO> {
    public List<T> list(Pager pager) throws Exception;
    public T detail(T dto) throws Exception;
    public int add(T dto, MultipartFile[] attach) throws Exception;  
    public int update(T dto) throws Exception;
    public int delete(T dto) throws Exception;
    public BoardFileDTO fileDetail(BoardFileDTO dto) throws Exception;
}
