package com.market.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.connect.dto.UserDto;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll()
				.stream()
				.map(MCMapper.INSTANCE::userToUserDto)
				.collect(Collectors.toList());
	}

}
