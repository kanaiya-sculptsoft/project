package com.angulardemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angulardemo.model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
