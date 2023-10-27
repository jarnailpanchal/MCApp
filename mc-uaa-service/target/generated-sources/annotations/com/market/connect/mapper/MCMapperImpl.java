package com.market.connect.mapper;

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.ManageCategoryDto;
import com.market.connect.dto.UserDto;
import com.market.connect.entity.BannerManager;
import com.market.connect.entity.CategoryManager;
import com.market.connect.entity.User;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T21:45:57+0530",
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
    public CategoryManager manageCategoryDtoToCategoryManagerEntity(ManageCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryManager categoryManager = new CategoryManager();

        categoryManager.setCategoryId( dto.getCategoryId() );
        categoryManager.setCategoryName( dto.getCategoryName() );
        categoryManager.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getCreatedDate() != null ) {
            categoryManager.setCreatedDate( Date.from( dto.getCreatedDate() ) );
        }
        categoryManager.setStatus( dto.getStatus() );
        if ( dto.getUpdateDate() != null ) {
            categoryManager.setUpdateDate( Date.from( dto.getUpdateDate() ) );
        }
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
        bannerManager.setUpdateDate( dto.getUpdateDate() );
        bannerManager.setUpdatedBy( dto.getUpdatedBy() );
        bannerManager.setUserId( dto.getUserId() );
        bannerManager.setVerificationStatus( dto.getVerificationStatus() );

        return bannerManager;
    }

    @Override
    public ManageCategoryDto toCategoryManagerDto(CategoryManager save) {
        if ( save == null ) {
            return null;
        }

        ManageCategoryDto manageCategoryDto = new ManageCategoryDto();

        manageCategoryDto.setCategoryId( save.getCategoryId() );
        manageCategoryDto.setCategoryName( save.getCategoryName() );
        manageCategoryDto.setCreatedBy( save.getCreatedBy() );
        if ( save.getCreatedDate() != null ) {
            manageCategoryDto.setCreatedDate( save.getCreatedDate().toInstant() );
        }
        manageCategoryDto.setStatus( save.getStatus() );
        if ( save.getUpdateDate() != null ) {
            manageCategoryDto.setUpdateDate( save.getUpdateDate().toInstant() );
        }
        manageCategoryDto.setUpdatedBy( save.getUpdatedBy() );

        return manageCategoryDto;
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
        bannerManagerDto.setUpdateDate( bannerManager.getUpdateDate() );
        bannerManagerDto.setUpdatedBy( bannerManager.getUpdatedBy() );
        bannerManagerDto.setUserId( bannerManager.getUserId() );
        bannerManagerDto.setVerificationStatus( bannerManager.getVerificationStatus() );

        return bannerManagerDto;
    }
}
