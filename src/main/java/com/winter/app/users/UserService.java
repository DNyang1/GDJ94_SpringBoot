package com.winter.app.users;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManager;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;

	@Autowired
	private FileManager fileManager;

	@Value("${app.upload.profile}")
	private String uploadPath;

	public int register(UserDTO dto, MultipartFile profile) throws Exception {
		int result = dao.register(dto);
		if (profile != null && !profile.isEmpty()) {

			File uploadFolder = new File(uploadPath);
			if (!uploadFolder.exists())
				uploadFolder.mkdirs();
			String savedFileName = fileManager.fileSave(uploadFolder, profile);
			ProfileDTO fileDTO = new ProfileDTO();
			fileDTO.setUsername(dto.getUsername());
			fileDTO.setFileName(savedFileName);
			fileDTO.setFileOrigin(profile.getOriginalFilename());
			dao.profileAdd(fileDTO);
		}
		return result;
	}
}