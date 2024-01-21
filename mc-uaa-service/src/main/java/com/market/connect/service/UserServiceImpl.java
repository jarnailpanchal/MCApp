package com.market.connect.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.market.connect.dto.UserDto;
import com.market.connect.entity.User;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Value("${upload.path}")
	private String uploadPath;

	@Transactional
	@Override
	public UserDto updateUser(Long userId, String firstName, String lastName, Instant birthDate, MultipartFile file) {
		User userEntity = new User();
		try {
			Optional<User> user = userRepository.findById(userId);
			String imageUrl = null;
			if (file != null) {
				InputStream inputStream = file.getInputStream();
				OutputStream outputStream = new FileOutputStream(
						uploadPath + userId + "_" + file.getOriginalFilename());
				IOUtils.copy(inputStream, outputStream);
				imageUrl = uploadPath + userId + "_" + file.getOriginalFilename();
			}

			if (!user.isEmpty()) {
				userEntity = user.get();
				userEntity.setImageUrl(imageUrl);
				if (firstName != null && firstName.length() > 0) {
					userEntity.setFirstName(firstName);
				}
				if (birthDate != null) {
					userEntity.setBirthdDate(birthDate);
				}
				if (lastName != null && lastName.length() > 0) {
					userEntity.setLastName(lastName);
				}
				userEntity.setUpdateDate(Instant.now());
				userEntity.setUpdatedBy(userId.toString());
				userRepository.save(userEntity);
			}
		} catch (Exception e) {
			log.error("error while updating user details : " + e.getMessage());
		}
		return MCMapper.INSTANCE.userToUserDto(userEntity);
	}

	@Override
	public UserDto getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		UserDto userDto = new UserDto();
		if (user.isPresent()) {
			userDto = MCMapper.INSTANCE.userToUserDto(user.get());
		}
		return userDto;
	}
}
