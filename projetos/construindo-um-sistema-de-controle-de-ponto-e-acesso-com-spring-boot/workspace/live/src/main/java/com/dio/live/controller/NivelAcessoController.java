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

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Nivel Acesso")
@RestController
@RequestMapping("/nivel-acesso")
public class NivelAcessoController {

	private NivelAcessoService nivelAcessoService;

	public NivelAcessoController(NivelAcessoService nivelAcessoService) {
		this.nivelAcessoService = nivelAcessoService;
	}

	@ApiOperation(value = "Salva um nivel de acesso")
	@PostMapping
	public NivelAcesso save(@RequestBody NivelAcesso nivelAcesso) {
		return nivelAcessoService.save(nivelAcesso);
	}

	@ApiOperation(value = "Retorna todas os niveis de acesso")
	@GetMapping
	public List<NivelAcesso> getList() {
		return nivelAcessoService.findAll();
	}

	@ApiOperation(value = "Retorna um nivel acesso por id")
	@GetMapping("/{id}")
	public ResponseEntity<NivelAcesso> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(nivelAcessoService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera um nivel de acesso")
	@PutMapping
	public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso) {
		return nivelAcessoService.update(nivelAcesso);
	}

	@ApiOperation(value = "Deleta um nivel de acesso")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			nivelAcessoService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
