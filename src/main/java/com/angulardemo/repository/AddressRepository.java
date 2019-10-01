package com.angulardemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angulardemo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
