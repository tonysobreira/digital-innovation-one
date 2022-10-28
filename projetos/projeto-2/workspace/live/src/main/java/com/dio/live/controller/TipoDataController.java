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

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Tipo Data")
@RestController
@RequestMapping("/tipo-data")
public class TipoDataController {

	private TipoDataService tipoDataService;

	public TipoDataController(TipoDataService tipoDataService) {
		this.tipoDataService = tipoDataService;
	}

	@ApiOperation(value = "Salva um tipo data")
	@PostMapping
	public TipoData save(@RequestBody TipoData tipoData) {
		return tipoDataService.save(tipoData);
	}

	@ApiOperation(value = "Retorna todas os tipos data")
	@GetMapping
	public List<TipoData> getList() {
		return tipoDataService.findAll();
	}

	@ApiOperation(value = "Retorna um tipo data por id")
	@GetMapping("/{id}")
	public ResponseEntity<TipoData> findById(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity
				.ok(tipoDataService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@ApiOperation(value = "Altera um tipo data")
	@PutMapping
	public TipoData update(@RequestBody TipoData tipoData) {
		return tipoDataService.update(tipoData);
	}

	@ApiOperation(value = "Deleta um tipo data")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {

		try {
			tipoDataService.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
