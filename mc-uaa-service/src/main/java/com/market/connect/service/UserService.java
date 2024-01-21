package com.market.connect.service;

import java.time.Instant;

import org.springframework.web.multipart.MultipartFile;

import com.market.connect.dto.UserDto;

public interface UserService {

	UserDto updateUser(Long userId, String firstName, String lastName, Instant birthDate, MultipartFile file);

	UserDto getUserById(Long userId);

}
