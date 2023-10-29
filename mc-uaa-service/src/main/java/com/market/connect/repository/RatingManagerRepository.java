package com.market.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.RatingManager;

@Repository
public interface RatingManagerRepository extends JpaRepository<RatingManager, Long>{

}
