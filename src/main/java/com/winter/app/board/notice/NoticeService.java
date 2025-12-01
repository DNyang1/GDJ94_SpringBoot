package com.winter.app.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService<NoticeDTO> {

    @Autowired
    private NoticeDAO dao;
    
    @Value("${app.upload.notice}")
    private String uploadPath;

    @Override
    public List<NoticeDTO> list(Pager pager) throws Exception {
        Long totalCount = dao.count();
        pager.pageing(totalCount);
        return dao.list(pager);
    }

    @Override
    public NoticeDTO detail(NoticeDTO dto) throws Exception {
        return dao.detail(dto);
    }
    
    @Override
    public int add(NoticeDTO dto, MultipartFile[] attach) throws Exception {
    	int result = dao.add(dto);
    	for (MultipartFile f : attach) {
			File file = new File(uploadPath);
			if(!file.exists()) file.mkdirs();

			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + f.getOriginalFilename();
			file = new File(file, fileName);
			
			FileCopyUtils.copy(f.getBytes(), file);
			BoardFileDTO fileDTO = new NoticeFileDTO();
			fileDTO.setFileName(fileName);
			fileDTO.setFileOrigin(f.getOriginalFilename());
			fileDTO.setBoardNum(dto.getBoardNum());
			dao.fileAdd(fileDTO);
		}
    	return result;
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
