package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.market.connect.dto.CompanyCustomDetailDto;
import com.market.connect.dto.CompanyWithCategoryCustomDto;
import com.market.connect.entity.CompanyManager;

@Repository
public interface CompanyManagerRepository extends JpaRepository<CompanyManager, Long>{

	
	  @Query("SELECT distinct NEW com.market.connect.dto.CompanyWithCategoryCustomDto(" +
	  "cm.categoryId,u.imageUrl,cm.companyId,cm.companyName ,"
	  + "	 CONCAT(cm.companyAddress ,',', cm.city ,',', cm.state) AS companyAddress  , "
	  + "	 cm.longtitude , cm.latitude , cm.description , u.phoneNumber , am.openTime , am.closingTime,"
	  + "	 COALESCE((SELECT AVG(rm2.ratedValue) FROM RatingManager rm2 WHERE rm2.companyId = cm.companyId),'0') as rating) "
	  + "	 from CompanyManager cm "
	  + "	 inner join User u on cm.userId = u.userId "
	  + "	 inner join AvailabilityManager am on cm.companyId = am.companyId "
	  + "	 where cm.categoryId =:categoryId and am.dayNumber =:dayNumber")
	  List<CompanyWithCategoryCustomDto> findCustomUserDetails(@Param("categoryId") Long
	  categoryId, @Param("dayNumber") String dayNumber);
	 
	
	  @Query("SELECT distinct NEW com.market.connect.dto.CompanyWithCategoryCustomDto(" +
			  "cm.categoryId,u.imageUrl,cm.companyId,cm.companyName ,"
			  + "	 CONCAT(cm.companyAddress ,',', cm.city ,',', cm.state) AS companyAddress  , "
			  + "	 cm.longtitude , cm.latitude , cm.description , u.phoneNumber , am.openTime , am.closingTime,"
			  + "	 COALESCE((SELECT AVG(rm2.ratedValue) FROM RatingManager rm2 WHERE rm2.companyId = cm.companyId),'0') as rating) "
			  + "	 from CompanyManager cm "
			  + "	 inner join User u on cm.userId = u.userId "
			  + "	 inner join AvailabilityManager am on cm.companyId = am.companyId and am.dayNumber =:dayNumber "
			  + "	 ")
	  List<CompanyWithCategoryCustomDto> findCustomUserDetails( @Param("dayNumber") String dayNumber);
	  
	  @Query("SELECT distinct NEW com.market.connect.dto.CompanyCustomDetailDto("
	  		  + "cm.categoryId , u.imageUrl, cm.companyId , cm.companyName ,"
	  		  + " concat(cm.companyAddress, ',', cm.city, ',', cm.state) as companyAddress ,"
	  		  + " cm.longtitude , cm.latitude, cm.description, u.phoneNumber ,"
	  		  + " av.openTime , av.closingTime ,"
	  		  + " avg(rm.ratedValue) as rating,"
	  		  + " bm.bannerUrl,"
	  		  + " count(rm.userId) as ratingCount) "
			  + " from CompanyManager cm "
			  + " inner join RatingManager rm on cm.companyId = rm.companyId and rm.status = 1 "
			  + " inner join User u on (cm.userId=u.userId and u.status = 1) "
			  + " inner join AvailabilityManager av on (cm.companyId=av.companyId) "
			  + " left outer join BannerManager bm on (cm.companyId=bm.companyId and bm.status = 1)"
			  + " where ( cm.status = 1) and cm.companyId =:companyId and av.dayNumber=:dayNumber group by bm.bannerUrl")
			  List<CompanyCustomDetailDto> getCompanyCustomDetail(@Param("companyId") Long
					  companyId, @Param("dayNumber") String dayNumber);
	 


}
