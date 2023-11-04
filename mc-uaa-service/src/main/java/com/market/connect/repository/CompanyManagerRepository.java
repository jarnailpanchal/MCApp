package com.market.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.CompanyManager;

@Repository
public interface CompanyManagerRepository extends JpaRepository<CompanyManager, Long>{

}
