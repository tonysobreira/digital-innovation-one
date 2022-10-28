package com.dio.live.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Calendario")
@RestController
@RequestMapping("/calendario")
public class CalendarioController {

	private CalendarioService calendarioService;

	public CalendarioController(CalendarioService calendarioService) {
		this.calendarioService = calendarioService;
	}

	@ApiOperation(value = "Salva um calendario")
	@PostMapping
	public Calendario save(@RequestBody Calendario calendario) {
		return calendarioService.save(calendario);
	}

	@ApiOperation(value = "Retorna todas os calendarios")
	@GetMapping
	public List<Calendario> getList() {
		return calendarioService.findAll();
	}

	@ApiOperation(value = "Retorna um calendario por id")
	@GetMapping("/{id}")
	public ResponseEntity<Calendario> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(calendarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera um calendario")
	@PutMapping
	public Calendario update(@RequestBody Calendario calendario) {
		return calendarioService.update(calendario);
	}

	@ApiOperation(value = "Deleta um calendario")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			calendarioService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
