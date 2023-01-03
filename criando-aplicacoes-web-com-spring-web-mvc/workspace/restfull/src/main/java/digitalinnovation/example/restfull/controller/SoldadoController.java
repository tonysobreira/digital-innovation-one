package digitalinnovation.example.restfull.controller;

import java.util.List;

import org.springframework.hateoas.Resources;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.restfull.controller.request.SoldadoEditRequest;
import digitalinnovation.example.restfull.controller.response.SoldadoListResponse;
import digitalinnovation.example.restfull.controller.response.SoldadoResponse;
import digitalinnovation.example.restfull.dto.SoldadoDTO;
import digitalinnovation.example.restfull.service.SoldadoService;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

	private SoldadoService soldadoService;
	
	private ObjectMapper objectMapper;
	
	public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper) {
		this.soldadoService = soldadoService;
		this.objectMapper = objectMapper;
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable("id") Long id) {
		SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
		return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
	}

	@PostMapping
	public ResponseEntity<SoldadoResponse> criarSoldado(@RequestBody SoldadoDTO soldadoDTO) {
		SoldadoResponse soldadoResponse = soldadoService.criarSoldado(soldadoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(soldadoResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoldadoResponse> atualizarSoldado(@PathVariable("id") Long id,
			@RequestBody SoldadoEditRequest soldadoEditRequest) {
		SoldadoResponse soldadoResponse = soldadoService.alterarSoldado(id, soldadoEditRequest);
		return ResponseEntity.ok(soldadoResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarSoldado(@PathVariable("id") Long id) {
		soldadoService.deletarSoldado(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/frente-castelo/{id}")
	public ResponseEntity<SoldadoResponse> frenteCastelo(@PathVariable("id") Long id) {
//		SoldadoResponse soldadoResponse = soldadoService.alterarSoldado(id, soldadoEditRequest);
//		return ResponseEntity.ok(soldadoResponse);
		//TODO Fazer algo
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Resources<SoldadoListResponse>> buscarSoldados() {
		Resources<SoldadoListResponse> soldadoListResponse = soldadoService.buscarSoldados();
		return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponse);
	}

}
