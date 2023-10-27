package com.market.connect.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.ManageCategoryDto;
import com.market.connect.dto.UserDto;
import com.market.connect.entity.BannerManager;
import com.market.connect.entity.CategoryManager;
import com.market.connect.entity.User;

@Mapper
public interface MCMapper {
	MCMapper INSTANCE = Mappers.getMapper(MCMapper.class);

	UserDto userToUserDto(User user);
	
	CategoryManager manageCategoryDtoToCategoryManagerEntity(ManageCategoryDto dto);
	
	BannerManager toBannerManager(BannerManagerDto dto);

	ManageCategoryDto toCategoryManagerDto(CategoryManager save);

	BannerManagerDto toBannerManagerDto(BannerManager bannerManager);
}
