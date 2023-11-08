package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

	List<Country> findAllByCountryNameIgnoreCase(String trim);

}
