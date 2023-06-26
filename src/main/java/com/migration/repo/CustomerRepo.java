package com.migration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migration.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	

}
