package com.market.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.BannerManager;

@Repository
public interface BannerManagerRepository extends JpaRepository<BannerManager, Long>{

}
