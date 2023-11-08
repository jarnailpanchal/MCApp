package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	List<City> findAllByStateId(Long stateId);

}
