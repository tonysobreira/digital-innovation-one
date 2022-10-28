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

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@ApiOperation(value = "Salva um usuario")
	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@ApiOperation(value = "Retorna todas os usuarios")
	@GetMapping
	public List<Usuario> getList() {
		return usuarioService.findAll();
	}

	@ApiOperation(value = "Retorna um usuario por id")
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(usuarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera um usuario")
	@PutMapping
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

	@ApiOperation(value = "Deleta um usuario")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			usuarioService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
