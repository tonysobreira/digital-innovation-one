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

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Movimentacao")
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	private MovimentacaoService movimentacaoService;

	public MovimentacaoController(MovimentacaoService movimentacaoService) {
		this.movimentacaoService = movimentacaoService;
	}

	@ApiOperation(value = "Salva uma movimentacao")
	@PostMapping
	public Movimentacao save(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.save(movimentacao);
	}

	@ApiOperation(value = "Retorna todas as movimentacoes")
	@GetMapping
	public List<Movimentacao> getList() {
		return movimentacaoService.findAll();
	}

	@ApiOperation(value = "Retorna uma movimentacao por id")
	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(movimentacaoService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma movimentacao")
	@PutMapping
	public Movimentacao update(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.update(movimentacao);
	}

	@ApiOperation(value = "Deleta uma movimentacao")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			movimentacaoService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
