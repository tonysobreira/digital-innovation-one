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

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Jornada Trabalho")
@RestController
@RequestMapping("/jornada-trabalho")
public class JornadaTrabalhoController {

	private JornadaTrabalhoService jornadaTrabalhoService;

	public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
		this.jornadaTrabalhoService = jornadaTrabalhoService;
	}

	@ApiOperation(value = "Salva uma jornada")
	@PostMapping
	public JornadaTrabalho save(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.save(jornadaTrabalho);
	}

	@ApiOperation(value = "Retorna todas as jornadas")
	@GetMapping
	public List<JornadaTrabalho> getList() {
		return jornadaTrabalhoService.findAll();
	}

	@ApiOperation(value = "Retorna uma jornada por id")
	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(jornadaTrabalhoService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma jornada")
	@PutMapping
	public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.update(jornadaTrabalho);
	}

	@ApiOperation(value = "Deleta uma jornada")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			jornadaTrabalhoService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
