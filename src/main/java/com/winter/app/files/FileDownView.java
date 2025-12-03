package com.winter.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
import org.yaml.snakeyaml.util.UriEncoder;

import com.winter.app.board.BoardFileDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownView extends AbstractView {
   
   @Value("${app.upload.base}")
   private String filePath;

   @Override
   protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      
//      Iterator<String> it = model.keySet().iterator();
//      
//      while(it.hasNext()) {
//         System.out.println(it.next());
//      }
      
      BoardFileDTO dto = (BoardFileDTO) model.get("file");
      String category = (String) model.get("category");
      
      File file = new File(filePath+category, dto.getFileName());
      
      // 한글 처리 
      response.setCharacterEncoding("UTF-8");
      
      // 총 파일의 크기 
      response.setContentLengthLong(file.length());
      
      // 다운로드시 파일명을 인코딩
      String origin = UriEncoder.encode(dto.getFileOrigin());
      
      // header 설정
      response.setHeader("Content-Disposition", "attachment;filename=\""+ origin + "\"");
      response.setHeader("Content-Transfer-Encoding", "binary");
      
      FileInputStream fi = new FileInputStream(file);
      
      OutputStream os = response.getOutputStream();
      FileCopyUtils.copy(fi, os);
      os.close();
      fi.close();
      
   }
}
