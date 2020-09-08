package com.wooster.contapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
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
        return ResponseEntity.ok().body(city);
    }
}
