package com.winter.app.board;

import java.util.List;
import com.winter.app.util.Pager;

public interface BoardDAO<T extends BoardDTO> {

    public T detail(T dto) throws Exception;
    public List<T> list(Pager pager) throws Exception;
    public int add(T dto) throws Exception;
    public int update(T dto) throws Exception;
    public int delete(T dto) throws Exception;
    public Long countList() throws Exception;
}
