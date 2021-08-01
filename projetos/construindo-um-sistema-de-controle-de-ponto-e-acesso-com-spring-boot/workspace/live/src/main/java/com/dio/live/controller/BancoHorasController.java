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

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Banco Horas")
@RestController
@RequestMapping("/banco-horas")
public class BancoHorasController {

	private BancoHorasService bancoHorasService;

	public BancoHorasController(BancoHorasService bancoHorasService) {
		this.bancoHorasService = bancoHorasService;
	}

	@ApiOperation(value = "Salva um banco horas")
	@PostMapping
	public BancoHoras save(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.save(bancoHoras);
	}

	@ApiOperation(value = "Retorna todas os banco horas")
	@GetMapping
	public List<BancoHoras> getList() {
		return bancoHorasService.findAll();
	}

	@ApiOperation(value = "Retorna um banco horas por id")
	@GetMapping("/{id}")
	public ResponseEntity<BancoHoras> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(bancoHorasService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera um banco horas")
	@PutMapping
	public BancoHoras update(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.update(bancoHoras);
	}

	@ApiOperation(value = "Deleta um banco horas")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			bancoHorasService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
