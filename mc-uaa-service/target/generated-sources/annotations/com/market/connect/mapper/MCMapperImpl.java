package com.market.connect.mapper;

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
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T13:22:23+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class MCMapperImpl implements MCMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setBirthdDate( user.getBirthdDate() );
        userDto.setCreatedDate( user.getCreatedDate() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setImageUrl( user.getImageUrl() );
        userDto.setLastName( user.getLastName() );
        userDto.setMiddleName( user.getMiddleName() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setStatus( user.getStatus() );
        userDto.setUpdateDate( user.getUpdateDate() );
        userDto.setUpdatedBy( user.getUpdatedBy() );
        userDto.setUserId( user.getUserId() );

        return userDto;
    }

    @Override
    public CategoryManager manageCategoryDtoToCategoryManagerEntity(CategoryManagerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryManager categoryManager = new CategoryManager();

        categoryManager.setCategoryDpUrl( dto.getCategoryDpUrl() );
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
        bannerManager.setUpdateDate( dto.getUpdateDate() );
        bannerManager.setUpdatedBy( dto.getUpdatedBy() );
        bannerManager.setVerificationStatus( dto.getVerificationStatus() );

        return bannerManager;
    }

    @Override
    public CategoryManagerDto toCategoryManagerDto(CategoryManager categoryManager) {
        if ( categoryManager == null ) {
            return null;
        }

        CategoryManagerDto categoryManagerDto = new CategoryManagerDto();

        categoryManagerDto.setCategoryDpUrl( categoryManager.getCategoryDpUrl() );
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
        bannerManagerDto.setUpdateDate( bannerManager.getUpdateDate() );
        bannerManagerDto.setUpdatedBy( bannerManager.getUpdatedBy() );
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
        companyManager.setCompanyName( companyManagerDto.getCompanyName() );
        companyManager.setCompanyStartDate( companyManagerDto.getCompanyStartDate() );
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
        companyManagerDto.setCompanyName( companyManager.getCompanyName() );
        companyManagerDto.setCompanyStartDate( companyManager.getCompanyStartDate() );
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

        user.setBirthdDate( userDto.getBirthdDate() );
        user.setCreatedDate( userDto.getCreatedDate() );
        user.setFirstName( userDto.getFirstName() );
        user.setImageUrl( userDto.getImageUrl() );
        user.setLastName( userDto.getLastName() );
        user.setMiddleName( userDto.getMiddleName() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setStatus( userDto.getStatus() );
        user.setUpdateDate( userDto.getUpdateDate() );
        user.setUpdatedBy( userDto.getUpdatedBy() );
        user.setUserId( userDto.getUserId() );

        return user;
    }

    @Override
    public AvailabilityManager toAvailabilityManager(AvailabilityManagerDto availabilityManagerDto) {
        if ( availabilityManagerDto == null ) {
            return null;
        }

        AvailabilityManager availabilityManager = new AvailabilityManager();

        availabilityManager.setClosingTime( availabilityManagerDto.getClosingTime() );
        availabilityManager.setCompanyId( availabilityManagerDto.getCompanyId() );
        availabilityManager.setDayNumber( availabilityManagerDto.getDayNumber() );
        availabilityManager.setId( availabilityManagerDto.getId() );
        availabilityManager.setOpenTime( availabilityManagerDto.getOpenTime() );

        return availabilityManager;
    }

    @Override
    public AvailabilityManagerDto toAvailabilityManagerDto(AvailabilityManager availabilityManager) {
        if ( availabilityManager == null ) {
            return null;
        }

        AvailabilityManagerDto availabilityManagerDto = new AvailabilityManagerDto();

        availabilityManagerDto.setClosingTime( availabilityManager.getClosingTime() );
        availabilityManagerDto.setCompanyId( availabilityManager.getCompanyId() );
        availabilityManagerDto.setDayNumber( availabilityManager.getDayNumber() );
        availabilityManagerDto.setId( availabilityManager.getId() );
        availabilityManagerDto.setOpenTime( availabilityManager.getOpenTime() );

        return availabilityManagerDto;
    }

    @Override
    public CommentManager toCommentManager(CommentManagerDto commentManagerDto) {
        if ( commentManagerDto == null ) {
            return null;
        }

        CommentManager commentManager = new CommentManager();

        commentManager.setCommentDate( commentManagerDto.getCommentDate() );
        commentManager.setCommentStatus( commentManagerDto.getCommentStatus() );
        commentManager.setCommentText( commentManagerDto.getCommentText() );
        commentManager.setCommenter( commentManagerDto.getCommenter() );
        commentManager.setCompanyId( commentManagerDto.getCompanyId() );
        commentManager.setCreatedBy( commentManagerDto.getCreatedBy() );
        commentManager.setId( commentManagerDto.getId() );
        commentManager.setReplyingTo( commentManagerDto.getReplyingTo() );

        return commentManager;
    }

    @Override
    public CommentManagerDto toCommentManagerDto(CommentManager comment) {
        if ( comment == null ) {
            return null;
        }

        CommentManagerDto commentManagerDto = new CommentManagerDto();

        commentManagerDto.setCommentDate( comment.getCommentDate() );
        commentManagerDto.setCommentStatus( comment.getCommentStatus() );
        commentManagerDto.setCommentText( comment.getCommentText() );
        commentManagerDto.setCommenter( comment.getCommenter() );
        commentManagerDto.setCompanyId( comment.getCompanyId() );
        commentManagerDto.setCreatedBy( comment.getCreatedBy() );
        commentManagerDto.setId( comment.getId() );
        commentManagerDto.setReplyingTo( comment.getReplyingTo() );

        return commentManagerDto;
    }

    @Override
    public LikeCommentManager toLikeCommentManager(LikeCommentManagerDto likeCommentManagerDto) {
        if ( likeCommentManagerDto == null ) {
            return null;
        }

        LikeCommentManager likeCommentManager = new LikeCommentManager();

        likeCommentManager.setCommentId( likeCommentManagerDto.getCommentId() );
        likeCommentManager.setDisliked( likeCommentManagerDto.isDisliked() );
        likeCommentManager.setId( likeCommentManagerDto.getId() );
        likeCommentManager.setLiked( likeCommentManagerDto.isLiked() );
        likeCommentManager.setUserId( likeCommentManagerDto.getUserId() );

        return likeCommentManager;
    }

    @Override
    public CompanyCustomDetailFinalDto toCompanyCustomDetailFinalDto(CompanyCustomDetailDto companyCustomDetailDto) {
        if ( companyCustomDetailDto == null ) {
            return null;
        }

        CompanyCustomDetailFinalDto companyCustomDetailFinalDto = new CompanyCustomDetailFinalDto();

        companyCustomDetailFinalDto.setCategoryId( companyCustomDetailDto.getCategoryId() );
        companyCustomDetailFinalDto.setClosingTime( companyCustomDetailDto.getClosingTime() );
        companyCustomDetailFinalDto.setCompanyAddress( companyCustomDetailDto.getCompanyAddress() );
        companyCustomDetailFinalDto.setCompanyBanners( companyCustomDetailDto.getCompanyBanners() );
        companyCustomDetailFinalDto.setCompanyId( companyCustomDetailDto.getCompanyId() );
        companyCustomDetailFinalDto.setCompanyName( companyCustomDetailDto.getCompanyName() );
        companyCustomDetailFinalDto.setDiscription( companyCustomDetailDto.getDiscription() );
        companyCustomDetailFinalDto.setImageUrl( companyCustomDetailDto.getImageUrl() );
        companyCustomDetailFinalDto.setLatitude( companyCustomDetailDto.getLatitude() );
        companyCustomDetailFinalDto.setLongtitude( companyCustomDetailDto.getLongtitude() );
        companyCustomDetailFinalDto.setMobileNumber( companyCustomDetailDto.getMobileNumber() );
        companyCustomDetailFinalDto.setOpenTime( companyCustomDetailDto.getOpenTime() );
        companyCustomDetailFinalDto.setRatedUserCount( companyCustomDetailDto.getRatedUserCount() );
        companyCustomDetailFinalDto.setRating( companyCustomDetailDto.getRating() );

        return companyCustomDetailFinalDto;
    }
}
