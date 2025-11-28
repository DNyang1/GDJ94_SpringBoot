package com.winter.app.board.qna;

import org.apache.ibatis.annotations.Mapper;
import com.winter.app.board.BoardDAO;

@Mapper
public interface QnaDAO extends BoardDAO<QnaDTO> {
    int refUpdate(QnaDTO dto) throws Exception;
}
