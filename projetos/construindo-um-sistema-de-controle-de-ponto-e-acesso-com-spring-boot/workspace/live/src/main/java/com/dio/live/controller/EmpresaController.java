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

import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Empresa")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	private EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@ApiOperation(value = "Salva uma empresa")
	@PostMapping
	public Empresa save(@RequestBody Empresa empresa) {
		return empresaService.save(empresa);
	}

	@ApiOperation(value = "Retorna todas as empresa")
	@GetMapping
	public List<Empresa> getList() {
		return empresaService.findAll();
	}

	@ApiOperation(value = "Retorna uma empresa por id")
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(empresaService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma empresa")
	@PutMapping
	public Empresa update(@RequestBody Empresa empresa) {
		return empresaService.update(empresa);
	}

	@ApiOperation(value = "Deleta uma empresa")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			empresaService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
