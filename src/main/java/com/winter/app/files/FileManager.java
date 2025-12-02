package com.winter.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public void fileDelete(File file) throws Exception{
		file.delete();
	}
	// TDD
	public String fileSave(File file, MultipartFile f) throws Exception {
		
		if (!file.exists()) file.mkdirs();
		String fileName = UUID.randomUUID().toString() + "_" + f.getOriginalFilename();
		file = new File(file, fileName);
		f.transferTo(file);
		return fileName;
	}
	
}
