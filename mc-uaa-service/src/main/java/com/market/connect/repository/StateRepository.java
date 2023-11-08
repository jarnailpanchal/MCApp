package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findAllByCountryId(Long countryId);

	List<State> findAllByStateNameIgnoreCase(String trim);

}
