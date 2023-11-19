package com.market.connect.mapper;

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.CategoryManagerDto;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.RatingManagerDto;
import com.market.connect.dto.RoleDto;
import com.market.connect.dto.UserDto;
import com.market.connect.entity.BannerManager;
import com.market.connect.entity.CategoryManager;
import com.market.connect.entity.CompanyManager;
import com.market.connect.entity.RatingManager;
import com.market.connect.entity.Role;
import com.market.connect.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T15:46:58+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class MCMapperImpl implements MCMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAddress( user.getAddress() );
        userDto.setAge( user.getAge() );
        if ( user.getCategoryId() != null ) {
            userDto.setCategoryId( String.valueOf( user.getCategoryId() ) );
        }
        userDto.setCity( user.getCity() );
        if ( user.getCompanyId() != null ) {
            userDto.setCompanyId( String.valueOf( user.getCompanyId() ) );
        }
        userDto.setCompanyName( user.getCompanyName() );
        userDto.setCountry( user.getCountry() );
        userDto.setCreatedBy( user.getCreatedBy() );
        userDto.setCreatedDate( user.getCreatedDate() );
        userDto.setEmailAddress( user.getEmailAddress() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setImageUrl( user.getImageUrl() );
        userDto.setLastName( user.getLastName() );
        userDto.setMiddleName( user.getMiddleName() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setPincode( user.getPincode() );
        if ( user.getRoleId() != null ) {
            userDto.setRoleId( String.valueOf( user.getRoleId() ) );
        }
        userDto.setState( user.getState() );
        userDto.setStatus( user.getStatus() );
        userDto.setUpdateDate( user.getUpdateDate() );
        userDto.setUpdatedBy( user.getUpdatedBy() );
        if ( user.getUserId() != null ) {
            userDto.setUserId( String.valueOf( user.getUserId() ) );
        }

        return userDto;
    }

    @Override
    public CategoryManager manageCategoryDtoToCategoryManagerEntity(CategoryManagerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryManager categoryManager = new CategoryManager();

        categoryManager.setCategoryId( dto.getCategoryId() );
        categoryManager.setCategoryName( dto.getCategoryName() );
        categoryManager.setCreatedBy( dto.getCreatedBy() );
        categoryManager.setCreatedDate( dto.getCreatedDate() );
        categoryManager.setStatus( dto.getStatus() );
        categoryManager.setUpdateDate( dto.getUpdateDate() );
        categoryManager.setUpdatedBy( dto.getUpdatedBy() );

        return categoryManager;
    }

    @Override
    public BannerManager toBannerManager(BannerManagerDto dto) {
        if ( dto == null ) {
            return null;
        }

        BannerManager bannerManager = new BannerManager();

        bannerManager.setBannerManagerId( dto.getBannerManagerId() );
        bannerManager.setBannerUrl( dto.getBannerUrl() );
        bannerManager.setCompanyId( dto.getCompanyId() );
        bannerManager.setCreatedBy( dto.getCreatedBy() );
        bannerManager.setCreatedDate( dto.getCreatedDate() );
        bannerManager.setStatus( dto.getStatus() );
        bannerManager.setType( dto.getType() );
        bannerManager.setUpdateDate( dto.getUpdateDate() );
        bannerManager.setUpdatedBy( dto.getUpdatedBy() );
        bannerManager.setUserId( dto.getUserId() );
        bannerManager.setVerificationStatus( dto.getVerificationStatus() );

        return bannerManager;
    }

    @Override
    public CategoryManagerDto toCategoryManagerDto(CategoryManager categoryManager) {
        if ( categoryManager == null ) {
            return null;
        }

        CategoryManagerDto categoryManagerDto = new CategoryManagerDto();

        categoryManagerDto.setCategoryId( categoryManager.getCategoryId() );
        categoryManagerDto.setCategoryName( categoryManager.getCategoryName() );
        categoryManagerDto.setCreatedBy( categoryManager.getCreatedBy() );
        categoryManagerDto.setCreatedDate( categoryManager.getCreatedDate() );
        categoryManagerDto.setStatus( categoryManager.getStatus() );
        categoryManagerDto.setUpdateDate( categoryManager.getUpdateDate() );
        categoryManagerDto.setUpdatedBy( categoryManager.getUpdatedBy() );

        return categoryManagerDto;
    }

    @Override
    public BannerManagerDto toBannerManagerDto(BannerManager bannerManager) {
        if ( bannerManager == null ) {
            return null;
        }

        BannerManagerDto bannerManagerDto = new BannerManagerDto();

        bannerManagerDto.setBannerManagerId( bannerManager.getBannerManagerId() );
        bannerManagerDto.setBannerUrl( bannerManager.getBannerUrl() );
        bannerManagerDto.setCompanyId( bannerManager.getCompanyId() );
        bannerManagerDto.setCreatedBy( bannerManager.getCreatedBy() );
        bannerManagerDto.setCreatedDate( bannerManager.getCreatedDate() );
        bannerManagerDto.setStatus( bannerManager.getStatus() );
        bannerManagerDto.setType( bannerManager.getType() );
        bannerManagerDto.setUpdateDate( bannerManager.getUpdateDate() );
        bannerManagerDto.setUpdatedBy( bannerManager.getUpdatedBy() );
        bannerManagerDto.setUserId( bannerManager.getUserId() );
        bannerManagerDto.setVerificationStatus( bannerManager.getVerificationStatus() );

        return bannerManagerDto;
    }

    @Override
    public CompanyManager toCompanyManager(CompanyManagerDto companyManagerDto) {
        if ( companyManagerDto == null ) {
            return null;
        }

        CompanyManager companyManager = new CompanyManager();

        companyManager.setCategoryId( companyManagerDto.getCategoryId() );
        companyManager.setCity( companyManagerDto.getCity() );
        companyManager.setCompanyAddress( companyManagerDto.getCompanyAddress() );
        companyManager.setCompanyId( companyManagerDto.getCompanyId() );
        companyManager.setCompanyStartDate( companyManagerDto.getCompanyStartDate() );
        companyManager.setCompanyType( companyManagerDto.getCompanyType() );
        companyManager.setCountry( companyManagerDto.getCountry() );
        companyManager.setCreatedBy( companyManagerDto.getCreatedBy() );
        companyManager.setCreatedDate( companyManagerDto.getCreatedDate() );
        companyManager.setDescription( companyManagerDto.getDescription() );
        companyManager.setLatitude( companyManagerDto.getLatitude() );
        companyManager.setLongtitude( companyManagerDto.getLongtitude() );
        companyManager.setState( companyManagerDto.getState() );
        companyManager.setStatus( companyManagerDto.getStatus() );
        companyManager.setUpdateDate( companyManagerDto.getUpdateDate() );
        companyManager.setUpdatedBy( companyManagerDto.getUpdatedBy() );
        companyManager.setUserId( companyManagerDto.getUserId() );

        return companyManager;
    }

    @Override
    public CompanyManagerDto toCompanyManagerDto(CompanyManager companyManager) {
        if ( companyManager == null ) {
            return null;
        }

        CompanyManagerDto companyManagerDto = new CompanyManagerDto();

        companyManagerDto.setCategoryId( companyManager.getCategoryId() );
        companyManagerDto.setCity( companyManager.getCity() );
        companyManagerDto.setCompanyAddress( companyManager.getCompanyAddress() );
        companyManagerDto.setCompanyId( companyManager.getCompanyId() );
        companyManagerDto.setCompanyStartDate( companyManager.getCompanyStartDate() );
        companyManagerDto.setCompanyType( companyManager.getCompanyType() );
        companyManagerDto.setCountry( companyManager.getCountry() );
        companyManagerDto.setCreatedBy( companyManager.getCreatedBy() );
        companyManagerDto.setCreatedDate( companyManager.getCreatedDate() );
        companyManagerDto.setDescription( companyManager.getDescription() );
        companyManagerDto.setLatitude( companyManager.getLatitude() );
        companyManagerDto.setLongtitude( companyManager.getLongtitude() );
        companyManagerDto.setState( companyManager.getState() );
        companyManagerDto.setStatus( companyManager.getStatus() );
        companyManagerDto.setUpdateDate( companyManager.getUpdateDate() );
        companyManagerDto.setUpdatedBy( companyManager.getUpdatedBy() );
        companyManagerDto.setUserId( companyManager.getUserId() );

        return companyManagerDto;
    }

    @Override
    public RatingManager toRatingManager(RatingManagerDto ratingManagerDto) {
        if ( ratingManagerDto == null ) {
            return null;
        }

        RatingManager ratingManager = new RatingManager();

        ratingManager.setCompanyId( ratingManagerDto.getCompanyId() );
        ratingManager.setRatedValue( ratingManagerDto.getRatedValue() );
        ratingManager.setRatingComment( ratingManagerDto.getRatingComment() );
        ratingManager.setRatingId( ratingManagerDto.getRatingId() );
        ratingManager.setStatus( ratingManagerDto.getStatus() );
        ratingManager.setUserId( ratingManagerDto.getUserId() );

        return ratingManager;
    }

    @Override
    public RatingManagerDto toRatingManagerDto(RatingManager ratingManager) {
        if ( ratingManager == null ) {
            return null;
        }

        RatingManagerDto ratingManagerDto = new RatingManagerDto();

        ratingManagerDto.setCompanyId( ratingManager.getCompanyId() );
        ratingManagerDto.setRatedValue( ratingManager.getRatedValue() );
        ratingManagerDto.setRatingComment( ratingManager.getRatingComment() );
        ratingManagerDto.setRatingId( ratingManager.getRatingId() );
        ratingManagerDto.setStatus( ratingManager.getStatus() );
        ratingManagerDto.setUserId( ratingManager.getUserId() );

        return ratingManagerDto;
    }

    @Override
    public Role toRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setCreatedBy( roleDto.getCreatedBy() );
        role.setCreatedDate( roleDto.getCreatedDate() );
        role.setRoleId( roleDto.getRoleId() );
        role.setRoleName( roleDto.getRoleName() );
        role.setStatus( roleDto.getStatus() );
        role.setUpdateDate( roleDto.getUpdateDate() );
        role.setUpdatedBy( roleDto.getUpdatedBy() );

        return role;
    }

    @Override
    public RoleDto toRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setCreatedBy( role.getCreatedBy() );
        roleDto.setCreatedDate( role.getCreatedDate() );
        roleDto.setRoleId( role.getRoleId() );
        roleDto.setRoleName( role.getRoleName() );
        roleDto.setStatus( role.getStatus() );
        roleDto.setUpdateDate( role.getUpdateDate() );
        roleDto.setUpdatedBy( role.getUpdatedBy() );

        return roleDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setAddress( userDto.getAddress() );
        user.setAge( userDto.getAge() );
        if ( userDto.getCategoryId() != null ) {
            user.setCategoryId( Long.parseLong( userDto.getCategoryId() ) );
        }
        user.setCity( userDto.getCity() );
        if ( userDto.getCompanyId() != null ) {
            user.setCompanyId( Long.parseLong( userDto.getCompanyId() ) );
        }
        user.setCompanyName( userDto.getCompanyName() );
        user.setCountry( userDto.getCountry() );
        user.setCreatedBy( userDto.getCreatedBy() );
        user.setCreatedDate( userDto.getCreatedDate() );
        user.setEmailAddress( userDto.getEmailAddress() );
        user.setFirstName( userDto.getFirstName() );
        user.setImageUrl( userDto.getImageUrl() );
        user.setLastName( userDto.getLastName() );
        user.setMiddleName( userDto.getMiddleName() );
        user.setPassword( userDto.getPassword() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setPincode( userDto.getPincode() );
        if ( userDto.getRoleId() != null ) {
            user.setRoleId( Long.parseLong( userDto.getRoleId() ) );
        }
        user.setState( userDto.getState() );
        user.setStatus( userDto.getStatus() );
        user.setUpdateDate( userDto.getUpdateDate() );
        user.setUpdatedBy( userDto.getUpdatedBy() );
        if ( userDto.getUserId() != null ) {
            user.setUserId( Long.parseLong( userDto.getUserId() ) );
        }

        return user;
    }
}
