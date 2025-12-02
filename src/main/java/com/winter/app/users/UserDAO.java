package com.winter.app.users;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	public int register(UserDTO dto) throws Exception;
	public int profileAdd(ProfileDTO dto) throws Exception;
}
