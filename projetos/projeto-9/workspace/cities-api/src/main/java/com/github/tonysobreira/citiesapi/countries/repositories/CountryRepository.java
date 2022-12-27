package com.github.tonysobreira.citiesapi.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.tonysobreira.citiesapi.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
