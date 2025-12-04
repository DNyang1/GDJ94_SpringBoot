package com.winter.app.users;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	public int register(UserDTO dto) throws Exception;
	public int profileAdd(ProfileDTO dto) throws Exception;
	public UserDTO detail(UserDTO dto) throws Exception; 
	public UserDTO login(UserDTO dto) throws Exception; 
	public int update(UserDTO dto) throws Exception;
	public void updateProfile(ProfileDTO dto); 
}
