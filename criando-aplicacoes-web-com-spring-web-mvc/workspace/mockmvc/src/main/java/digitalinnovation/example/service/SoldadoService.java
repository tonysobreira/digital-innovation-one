package digitalinnovation.example.service;

import org.springframework.stereotype.Service;

import digitalinnovation.example.dto.Soldado;

@Service
public class SoldadoService {

	public Soldado getSoldado() {
		return new Soldado();
	}

	public void salvarSoldado(Soldado soldado) {
	}

}