package com.winter.app.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class QnaService implements BoardService<QnaDTO> {

	@Autowired
	private QnaDAO dao;

	@Autowired
	private FileManager fileManager;

	@Value("${app.upload.qna}")
	private String uploadPath;

	@Override
	public List<QnaDTO> list(Pager pager) throws Exception {
		Long totalCount = dao.count();
		pager.pageing(totalCount);
		return dao.list(pager);
	}

	@Override
	public QnaDTO detail(QnaDTO dto) throws Exception {
		return dao.detail(dto);
	}

	@Override
	public int add(QnaDTO dto, MultipartFile[] attach) throws Exception {
		int result = dao.add(dto);
		dao.refUpdate(dto);
		File file = new File(uploadPath);
		if (attach != null && attach.length > 0) {

			for (MultipartFile f : attach) {
				if (f == null || f.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(file, f);
				BoardFileDTO fileDTO = new BoardFileDTO();
				fileDTO.setFileName(fileName);
				fileDTO.setFileOrigin(f.getOriginalFilename());
				fileDTO.setBoardNum(dto.getBoardNum());

				dao.fileAdd(fileDTO);
			}
		}
		return result;
	}

	@Override
	public int update(QnaDTO dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public int delete(QnaDTO dto) throws Exception {
		dto = dao.detail(dto);
    	for(BoardFileDTO fileDTO:dto.getFileDTOs()) {
    		File file = new File(uploadPath, fileDTO.getFileName());
    		fileManager.fileDelete(file);
    	}
    	dao.fileDelete(dto);
		return dao.delete(dto);
	}

	public int reply(QnaDTO dto) throws Exception {
		QnaDTO parent = dao.detail(dto);
		dao.stepUpdate(parent);
		dto.setBoardRef(parent.getBoardRef());
		dto.setBoardStep(parent.getBoardStep() + 1);
		dto.setBoardDepth(parent.getBoardDepth() + 1);
		return dao.reply(dto);
	}

}
