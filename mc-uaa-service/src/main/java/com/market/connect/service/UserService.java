package com.market.connect.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.market.connect.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();

	Page<UserDto> searchUsers( int page, int size, String sort);

}
