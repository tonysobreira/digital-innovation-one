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

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Ocorrencia")
@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

	private OcorrenciaService ocorrenciaService;

	public OcorrenciaController(OcorrenciaService ocorrenciaService) {
		this.ocorrenciaService = ocorrenciaService;
	}

	@ApiOperation(value = "Salva uma ocorrencia")
	@PostMapping
	public Ocorrencia save(@RequestBody Ocorrencia ocorrencia) {
		return ocorrenciaService.save(ocorrencia);
	}

	@ApiOperation(value = "Retorna todas as ocorrencias")
	@GetMapping
	public List<Ocorrencia> getList() {
		return ocorrenciaService.findAll();
	}

	@ApiOperation(value = "Retorna uma ocorrencia por id")
	@GetMapping("/{id}")
	public ResponseEntity<Ocorrencia> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(ocorrenciaService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma ocorrencia")
	@PutMapping
	public Ocorrencia update(@RequestBody Ocorrencia ocorrencia) {
		return ocorrenciaService.update(ocorrencia);
	}

	@ApiOperation(value = "Deleta uma ocorrencia")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			ocorrenciaService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
