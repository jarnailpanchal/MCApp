package com.market.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.market.connect.dto.UserDto;
import com.market.connect.entity.CategoryManager;
import com.market.connect.entity.ManagePassword;
import com.market.connect.entity.User;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.ManageCategoryRepository;
import com.market.connect.repository.ManagePasswordRepository;
import com.market.connect.repository.UserRepository;

import ch.qos.logback.core.boolex.EvaluationException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ManagePasswordRepository managePasswordRepository;

	@Autowired
	private ManageCategoryRepository categoryRepository;

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(MCMapper.INSTANCE::userToUserDto).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> searchUsers(String category) {
		List<CategoryManager> categories = categoryRepository.findByCategoryNameIgnoreCase(category);
		Long categoryId = null;
		if (categories.size() > 0) {
			categoryId = categories.get(0).getCategoryId();
		}
		return userRepository.findAllByCategoryId(categoryId).stream().map(MCMapper.INSTANCE::userToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto save(UserDto userDto) throws Exception {
		List<User> existUser = userRepository.findByPhoneNumber(userDto.getPhoneNumber());
		if (existUser.size() > 0) {
			throw new EvaluationException("User alreay exist with this mobile number");
		} else {
			User user = MCMapper.INSTANCE.toUser(userDto);
			ManagePassword managerPassword = managePasswordRepository.findByMobileNumber(userDto.getPhoneNumber());
			if (managerPassword == null) {
				throw new AttributeNotFoundException(userDto.getPhoneNumber() + " OTP not verified");
			}
			User savedUser = userRepository.save(user);
			managerPassword.setUserId(savedUser.getUserId());
			managePasswordRepository.save(managerPassword);
		}
		return null;
	}

}
