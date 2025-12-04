package com.winter.app.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	@NotBlank
	private String username;

	@NotBlank(groups = {RegisterGroup.class})
	private String password;

	@NotBlank(groups = {RegisterGroup.class, UpdateGroup.class})
	private String name;

	@NotBlank
	@Email(message = "올바른 이메일 형식을 입력해주세요.")
	private String email;

	@NotBlank
	private String phone;
	private String birth;
	@NotBlank(message = "비밀번호 확인은 필수 입력값입니다.")
	private String passwordCheck;
}
