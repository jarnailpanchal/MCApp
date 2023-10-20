package com.market.connect.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.market.connect.dto.UserDto;
import com.market.connect.entity.User;

@Mapper
public interface MCMapper {
	MCMapper INSTANCE = Mappers.getMapper(MCMapper.class);

	UserDto userToUserDto(User user);
}
