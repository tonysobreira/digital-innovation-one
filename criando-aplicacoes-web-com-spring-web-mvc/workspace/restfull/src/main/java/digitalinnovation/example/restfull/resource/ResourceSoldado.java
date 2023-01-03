package digitalinnovation.example.restfull.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.restfull.controller.SoldadoController;
import digitalinnovation.example.restfull.controller.response.SoldadoListResponse;
import digitalinnovation.example.restfull.controller.response.SoldadoResponse;
import digitalinnovation.example.restfull.model.Soldado;

@Component
public class ResourceSoldado {

	private ObjectMapper objectMapper;

	public ResourceSoldado(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public SoldadoListResponse criarLink(Soldado soldado) {
		SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldado, SoldadoListResponse.class);
		Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldado.getId())).withSelfRel();
		soldadoListResponse.add(link);
		return soldadoListResponse;
	}
	
	public SoldadoResponse criarLinkDetalhe(Soldado soldado) {
		SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
		
		if (soldado.getStatus().equals("morto")) {
			Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldado.getId()))
					.withRel("remover")
					.withTitle("Deletar Soldado")
					.withType("delete");
					
			soldadoResponse.add(link);
		} else if (soldado.getStatus().equals("vivo")) {
			Link link = linkTo(methodOn(SoldadoController.class).frenteCastelo(soldado.getId()))
					.withRel("batalhar")
					.withTitle("Ir para a frente do castelo")
					.withType("put");
					
			soldadoResponse.add(link);
		}
		
		return soldadoResponse;
	}

}
