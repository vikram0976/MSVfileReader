package com.migration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migration.entity.Supply;

public interface SupplyRepo extends JpaRepository<Supply, Integer> {

}
