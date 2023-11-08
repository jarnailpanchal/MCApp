package com.market.connect.service;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.market.connect.entity.City;
import com.market.connect.entity.Country;
import com.market.connect.entity.State;
import com.market.connect.repository.CityRepository;
import com.market.connect.repository.CountryRepository;
import com.market.connect.repository.StateRepository;

@Service
public class LocalityServiceImpl implements LocalityService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<String> getAllCountry() {

		return null;
	}

	@Override
	@Transactional
	public void saveCountry() {
		List<String> countries = countryRepository.findAll().stream().map(Country::getCountryName)
				.collect(Collectors.toList());
		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
		String[] countryCodes = Locale.getISOCountries();
		for (String countryCode : countryCodes) {
			Locale obj = new Locale("", countryCode);
			int countryPhoneCode = phoneNumberUtil.getCountryCodeForRegion(obj.getCountry());
			System.out.println("Country Code = " + countryPhoneCode + " : " + obj.getCountry() + ", Country Name = "
					+ obj.getDisplayCountry());
			if (!countries.contains(obj.getDisplayCountry())) {
				Country country = new Country();
				country.setCountryName(obj.getDisplayCountry());
				country.setCreatedBy("Admin");
				country.setCreatedDate(Instant.now());
				country.setPhoneCode(countryPhoneCode);
				country.setShortName(obj.getCountry());
				country.setStatus("1");
				countryRepository.save(country);
			}
		}

	}

	@Override
	public List<String> getState(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDistrict(String country, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCity(String country, String state, String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAllCountries() {
		List<String> countries = countryRepository.findAll().stream().map(Country::getCountryName)
				.collect(Collectors.toList());
		return countries;
	}

	@Override
	public List<String> findAllStateByCountry(String country) {
		List<Country> countries = countryRepository.findAllByCountryNameIgnoreCase(country.trim());
		Long countryId = null;
		if (countries.size() > 0) {
			countryId = countries.get(0).getCountryId();
		}
		return stateRepository.findAllByCountryId(countryId).stream().map(State::getStateName)
				.collect(Collectors.toList());
	}

	@Override
	public List<String> findAllCitiesByState(String state) {
		List<State> states = stateRepository.findAllByStateNameIgnoreCase(state.trim());
		Long stateId = null;
		if (states.size() > 0) {
			stateId = states.get(0).getStateId();
		}
		return cityRepository.findAllByStateId(stateId).stream().map(City::getCityName)
				.collect(Collectors.toList());
	}

}
