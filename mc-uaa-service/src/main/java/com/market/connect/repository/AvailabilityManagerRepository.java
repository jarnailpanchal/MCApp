package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.AvailabilityManager;

@Repository
public interface AvailabilityManagerRepository extends JpaRepository<AvailabilityManager, Long> {

	List<AvailabilityManager> findAllByCompanyId(Long companyId);

	@Modifying
	@Query("DELETE FROM AvailabilityManager e WHERE e.companyId = :companyId")
	void deleteByCompanyId(Long companyId);

}
