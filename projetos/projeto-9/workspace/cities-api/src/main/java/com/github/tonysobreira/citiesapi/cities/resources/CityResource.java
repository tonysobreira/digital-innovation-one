package com.github.tonysobreira.citiesapi.cities.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.tonysobreira.citiesapi.cities.entities.City;
import com.github.tonysobreira.citiesapi.cities.repositories.CityRepository;

@RestController
@RequestMapping("cities")
public class CityResource {

	private final CityRepository repository;

	public CityResource(final CityRepository repository) {
		this.repository = repository;
	}

	// 1st
//  @GetMapping
//  public List<City> cities() {
//      return repository.findAll();
//  }

	// 2nd - Pageable
	@GetMapping
	public Page<City> cities(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) final Pageable page) {
		return repository.findAll(page);
	}

}