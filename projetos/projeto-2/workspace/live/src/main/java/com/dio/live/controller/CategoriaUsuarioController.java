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

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Categoria Usuario")
@RestController
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

	private CategoriaUsuarioService categoriaUsuarioService;

	public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
		this.categoriaUsuarioService = categoriaUsuarioService;
	}

	@ApiOperation(value = "Salva uma categoria usuario")
	@PostMapping
	public CategoriaUsuario save(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.save(categoriaUsuario);
	}

	@ApiOperation(value = "Retorna todas as categorias usuario")
	@GetMapping
	public List<CategoriaUsuario> getList() {
		return categoriaUsuarioService.findAll();
	}

	@ApiOperation(value = "Retorna uma categoria usuario por id")
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaUsuario> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(categoriaUsuarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera uma categoria usuario")
	@PutMapping
	public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.update(categoriaUsuario);
	}

	@ApiOperation(value = "Deleta uma categoria usuario")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			categoriaUsuarioService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
