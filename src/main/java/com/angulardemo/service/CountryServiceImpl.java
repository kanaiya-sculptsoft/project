package com.angulardemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angulardemo.model.Country;
import com.angulardemo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
    @Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> findAllCountry() {
		return countryRepository.findAll();
    }
}	
