package com.wooster.contapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wooster.contapp.repository.CityRepository;
import com.wooster.contapp.entity.City;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Version 1 controller for City CRUD APIs
 * @author pta200
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CityController {

	@Autowired
	private CityRepository cityRepos;

	@GetMapping("/cities")
	public List <City> getAllCities() {
		return cityRepos.findAll();
	}

	@GetMapping("/cities/{cityid}")
	public ResponseEntity<Optional<City>>  getCityById(@PathVariable(value = "cityid") UUID cityId) {
		Optional<City>  city = cityRepos.findById(cityId);

		if (city == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@PostMapping("/cities")
	public City addCity(@RequestBody City city) {
		return cityRepos.save(city);
	}

	@PutMapping("/cities")
	public City updateCity(@RequestBody City city) {
		return cityRepos.save(city);
	}

	@DeleteMapping("/cities/{cityId}")
	public void deletCity(@PathVariable(value = "cityid") UUID cityId) {
		cityRepos.deleteById(cityId);
	}
}
