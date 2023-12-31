package com.market.connect.service;

import java.util.List;

import com.market.connect.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();

	UserDto save(UserDto userDto) throws Exception;

	List<UserDto> searchUsers(String category);

}
