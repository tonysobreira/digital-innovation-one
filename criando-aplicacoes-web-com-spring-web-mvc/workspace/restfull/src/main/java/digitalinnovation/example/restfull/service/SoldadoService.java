package digitalinnovation.example.restfull.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.restfull.controller.request.SoldadoEditRequest;
import digitalinnovation.example.restfull.controller.response.SoldadoListResponse;
import digitalinnovation.example.restfull.controller.response.SoldadoResponse;
import digitalinnovation.example.restfull.dto.SoldadoDTO;
import digitalinnovation.example.restfull.exception.SoldadoNotFoundException;
import digitalinnovation.example.restfull.model.Soldado;
import digitalinnovation.example.restfull.repository.SoldadoRepository;
import digitalinnovation.example.restfull.resource.ResourceSoldado;

@Service
public class SoldadoService {

	private SoldadoRepository soldadoRepository;

	private ObjectMapper objectMapper;
	
	private ResourceSoldado resourceSoldado;

	public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper, ResourceSoldado resourceSoldado) {
		this.soldadoRepository = soldadoRepository;
		this.objectMapper = objectMapper;
		this.resourceSoldado = resourceSoldado;
	}

	public SoldadoResponse buscarSoldado(Long id) {
		Soldado soldado = soldadoRepository.findById(id).orElseThrow(() -> new SoldadoNotFoundException());
		//SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
		SoldadoResponse soldadoResponse = resourceSoldado.criarLinkDetalhe(soldado);
		return soldadoResponse;
	}

	public SoldadoResponse criarSoldado(SoldadoDTO soldadoDTO) {
		Soldado soldado = objectMapper.convertValue(soldadoDTO, Soldado.class);
		soldadoRepository.save(soldado);
		SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
		return soldadoResponse;
	}

	public SoldadoResponse alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
		Soldado soldado = objectMapper.convertValue(soldadoEditRequest, Soldado.class);
		soldado.setId(id);
		soldadoRepository.save(soldado);
		SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
		return soldadoResponse;
	}

	public void deletarSoldado(Long id) {
		Soldado soldado = soldadoRepository.findById(id).orElseThrow(() -> new SoldadoNotFoundException());
		soldadoRepository.delete(soldado);
	}

	public Resources<SoldadoListResponse> buscarSoldados() {
		List<Soldado> list = soldadoRepository.findAll();
		List<SoldadoListResponse> listResponse = list.stream()
				.map(x -> resourceSoldado.criarLink(x))
				.collect(Collectors.toList());
		return new Resources<>(listResponse);
	}

}
