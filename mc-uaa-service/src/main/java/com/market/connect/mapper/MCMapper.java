package com.market.connect.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.market.connect.dto.AvailabilityManagerDto;
import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.CategoryManagerDto;
import com.market.connect.dto.CommentManagerDto;
import com.market.connect.dto.CompanyCustomDetailDto;
import com.market.connect.dto.CompanyCustomDetailFinalDto;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.LikeCommentManagerDto;
import com.market.connect.dto.RatingManagerDto;
import com.market.connect.dto.RoleDto;
import com.market.connect.dto.UserDto;
import com.market.connect.entity.AvailabilityManager;
import com.market.connect.entity.BannerManager;
import com.market.connect.entity.CategoryManager;
import com.market.connect.entity.CommentManager;
import com.market.connect.entity.CompanyManager;
import com.market.connect.entity.LikeCommentManager;
import com.market.connect.entity.RatingManager;
import com.market.connect.entity.Role;
import com.market.connect.entity.User;

@Mapper
public interface MCMapper {
	MCMapper INSTANCE = Mappers.getMapper(MCMapper.class);

	UserDto userToUserDto(User user);
	
	CategoryManager manageCategoryDtoToCategoryManagerEntity(CategoryManagerDto dto);
	
	BannerManager toBannerManager(BannerManagerDto dto);

	CategoryManagerDto toCategoryManagerDto(CategoryManager categoryManager);

	BannerManagerDto toBannerManagerDto(BannerManager bannerManager);

	CompanyManager toCompanyManager(CompanyManagerDto companyManagerDto);
	
	CompanyManagerDto toCompanyManagerDto(CompanyManager companyManager);

	RatingManager toRatingManager(RatingManagerDto ratingManagerDto);

	RatingManagerDto toRatingManagerDto(RatingManager ratingManager);

	Role toRole(RoleDto roleDto);

	RoleDto toRoleDto(Role role);

	User toUser(UserDto userDto);
	
	AvailabilityManager toAvailabilityManager(AvailabilityManagerDto availabilityManagerDto);
	
	AvailabilityManagerDto toAvailabilityManagerDto(AvailabilityManager availabilityManager);

	CommentManager toCommentManager(CommentManagerDto commentManagerDto);

	CommentManagerDto toCommentManagerDto(CommentManager comment);

	LikeCommentManager toLikeCommentManager(LikeCommentManagerDto likeCommentManagerDto);

	CompanyCustomDetailFinalDto toCompanyCustomDetailFinalDto(CompanyCustomDetailDto companyCustomDetailDto);
}
