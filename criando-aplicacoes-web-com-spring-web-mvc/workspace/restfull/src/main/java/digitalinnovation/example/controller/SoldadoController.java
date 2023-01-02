package digitalinnovation.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digitalinnovation.example.controller.request.SoldadoEditRequest;
import digitalinnovation.example.model.Soldado;
import digitalinnovation.example.service.SoldadoService;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

	@Autowired
	private SoldadoService service;

	@GetMapping
	public ResponseEntity<List<Soldado>> buscarSoldados() {
		List<Soldado> soldados = service.buscarSoldados();
		return ResponseEntity.ok(soldados);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Soldado> buscarSoldado(@PathVariable("id") Long id) {
		Soldado soldado = service.buscarSoldado(id);
		return ResponseEntity.ok(soldado);
	}

	@PostMapping
	public ResponseEntity<Soldado> criarSoldado(@RequestBody Soldado soldado) {
		service.criarSoldado(soldado);
		return ResponseEntity.status(HttpStatus.CREATED).body(soldado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Soldado> atualizarSoldado(@PathVariable("id") Long id,
			@RequestBody SoldadoEditRequest soldadoEditRequest) {
		Soldado soldado = service.alterarSoldado(id, soldadoEditRequest);
		return ResponseEntity.ok(soldado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarSoldado(@PathVariable("id") Long id) {
		service.deletarSoldado(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
