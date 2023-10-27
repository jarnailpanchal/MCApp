package com.market.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public Page<UserDto> searchUsers(int page, int size, String sort) {
		Pageable pageable = null;
	    if (sort != null) {
	      // with sorting
	      pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
	    } else {
	      // without sorting
	      pageable = PageRequest.of(page, size);
	    }
	    return userRepository.findAll(pageable).map(MCMapper.INSTANCE::userToUserDto);
	}

}
