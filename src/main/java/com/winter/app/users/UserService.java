package com.winter.app.users;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import com.winter.app.board.notice.NoticeService;
import com.winter.app.config.MessageConfig;
import com.winter.app.files.FileDownView;
import com.winter.app.files.FileManager;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;

	@Autowired
	private FileManager fileManager;

	@Value("${app.upload.profile}")
	private String uploadPath;

	public Boolean getError(UserDTO dto, BindingResult bindingResult) throws Exception {
		// check : true -> 검증 실패, error 존재
		// check : flase -> 검증 성공, error 존재 X
		// 1. annotation 검증 결과
		boolean check = bindingResult.hasErrors();

		// 2. password 일치 하는지 검증
		if (!dto.getPassword().equals(dto.getPasswordCheck())) {
			check = true;
			// bindingResult.reject("멤버변수명", "properties의 키값");
			bindingResult.rejectValue("passwordCheck", "user.password.equal");
		}
		return check;
	}

	public int update(UserDTO dto, MultipartFile profile) throws Exception {

		int result = dao.update(dto);

		if (profile != null && !profile.isEmpty()) {

			File uploadFolder = new File(uploadPath);
			if (!uploadFolder.exists())
				uploadFolder.mkdirs();

			String savedFileName = fileManager.fileSave(uploadFolder, profile);

			ProfileDTO fileDTO = new ProfileDTO();
			fileDTO.setUsername(dto.getUsername());
			fileDTO.setFileName(savedFileName);
			fileDTO.setFileOrigin(profile.getOriginalFilename());

			dao.updateProfile(fileDTO);
		}

		return result;
	}

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

	public UserDTO login(UserDTO dto) throws Exception {
		return dao.login(dto);
	}

	public UserDTO detail(UserDTO dto) throws Exception {
		return dao.detail(dto);
	}
}