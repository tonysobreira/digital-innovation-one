package com.github.tonysobreira.citiesapi.states.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.tonysobreira.citiesapi.states.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}