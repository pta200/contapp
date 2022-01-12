package com.wooster.contapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooster.contapp.entity.City;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * City JPA repository
 * @author pta200
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, UUID>{
	
	List <City> findAll();
	Optional<City> findById(UUID cityId);

}
