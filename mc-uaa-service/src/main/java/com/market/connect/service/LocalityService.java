package com.market.connect.service;

import java.util.List;

public interface LocalityService {

	List<String> getAllCountry();
	
	List<String> getState(String country);
	
	List<String> getDistrict(String country, String state);
	
	List<String> getCity(String country, String state, String district);

	void saveCountry();

	List<String> findAllCountries();

	List<String> findAllStateByCountry(String country);

	List<String> findAllCitiesByState(String state);
}
