package digitalinnovation.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalinnovation.example.controller.request.SoldadoEditRequest;
import digitalinnovation.example.exception.SoldadoNotFoundException;
import digitalinnovation.example.model.Soldado;
import digitalinnovation.example.repository.SoldadoRepository;

@Service
public class SoldadoService {

	@Autowired
	private SoldadoRepository repository;

	public List<Soldado> buscarSoldados() {
		return repository.findAll();
	}

	public Soldado buscarSoldado(Long id) {
		Optional<Soldado> soldadoOptional = repository.findById(id);

		if (soldadoOptional.isPresent()) {
			return soldadoOptional.get();
		}

		throw new SoldadoNotFoundException();
	}

	public Soldado criarSoldado(Soldado soldado) {
		return repository.save(soldado);
	}

	public Soldado alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
		Soldado soldado = buscarSoldado(id);

		soldado.setNome(soldadoEditRequest.getNome());
		soldado.setRaca(soldadoEditRequest.getRaca());
		soldado.setArma(soldadoEditRequest.getArma());

		return repository.save(soldado);
	}

	public void deletarSoldado(Long id) {
		Soldado soldado = buscarSoldado(id);
		repository.delete(soldado);
//		repository.deleteById(id);
	}

}
