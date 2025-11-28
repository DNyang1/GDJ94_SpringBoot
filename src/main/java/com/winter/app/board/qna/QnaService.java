package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;


@Service
public class QnaService implements BoardService<QnaDTO> {

    @Autowired
    private QnaDAO dao;

    @Override
    public List<QnaDTO> list(Pager pager) throws Exception {
        Long totalCount = dao.countList();
        pager.pageing(totalCount);
        return dao.list(pager);
    }

    @Override
    public QnaDTO detail(QnaDTO dto) throws Exception {
        return dao.detail(dto);
    }

    @Override
    public int add(QnaDTO dto) throws Exception {
        dao.add(dto);
        return dao.refUpdate(dto);
    }

    @Override
    public int update(QnaDTO dto) throws Exception {
        return dao.update(dto);
    }

    @Override
    public int delete(QnaDTO dto) throws Exception {
        return dao.delete(dto);
    }
}

