package com.market.connect.mapper;

import com.market.connect.dto.UserDto;
import com.market.connect.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T08:35:55+0530",
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
}
