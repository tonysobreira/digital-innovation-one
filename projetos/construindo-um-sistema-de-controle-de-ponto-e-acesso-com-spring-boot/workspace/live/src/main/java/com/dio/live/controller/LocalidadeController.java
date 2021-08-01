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

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Localidade")
@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

	private LocalidadeService localidadeService;

	public LocalidadeController(LocalidadeService localidadeService) {
		this.localidadeService = localidadeService;
	}

	@ApiOperation(value = "Salva uma localidade")
	@PostMapping
	public Localidade save(@RequestBody Localidade localidade) {
		return localidadeService.save(localidade);
	}

	@ApiOperation(value = "Retorna todas as localidades")
	@GetMapping
	public List<Localidade> getList() {
		return localidadeService.findAll();
	}

	@ApiOperation(value = "Retorna uma localidade por id")
	@GetMapping("/{id}")
	public ResponseEntity<Localidade> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(localidadeService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma localidade")
	@PutMapping
	public Localidade update(@RequestBody Localidade localidade) {
		return localidadeService.update(localidade);
	}

	@ApiOperation(value = "Deleta uma localidade")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			localidadeService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
