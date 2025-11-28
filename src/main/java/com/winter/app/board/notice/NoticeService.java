package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService<NoticeDTO> {

    @Autowired
    private NoticeDAO dao;

    @Override
    public List<NoticeDTO> list(Pager pager) throws Exception {
        Long totalCount = dao.countList();
        pager.pageing(totalCount);
        return dao.list(pager);
    }

    @Override
    public NoticeDTO detail(NoticeDTO dto) throws Exception {
        return dao.detail(dto);
    }

    @Override
    public int add(NoticeDTO dto) throws Exception {
        return dao.add(dto);
    }

    @Override
    public int update(NoticeDTO dto) throws Exception {
        return dao.update(dto);
    }

    @Override
    public int delete(NoticeDTO dto) throws Exception {
        return dao.delete(dto);
    }
}
