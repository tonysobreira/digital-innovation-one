package com.github.tonysobreira.citiesapi.states.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.tonysobreira.citiesapi.states.entities.State;
import com.github.tonysobreira.citiesapi.states.repositories.StateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {

	private final StateRepository repository;

	public StateResource(final StateRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<State> states() {
		return repository.findAll();
	}

}