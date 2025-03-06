package com.rnit.Nabangga_na_ba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnit.Nabangga_na_ba.entity.Cars;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {
    Optional<Cars> findByPlateNo(String plateNo);
}
