package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	private OcorrenciaRepository ocorrenciaRepository;

	public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
		this.ocorrenciaRepository = ocorrenciaRepository;
	}

	public Ocorrencia save(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public List<Ocorrencia> findAll() {
		return ocorrenciaRepository.findAll();
	}

	public Optional<Ocorrencia> findById(Long id) {
		return ocorrenciaRepository.findById(id);
	}

	public Ocorrencia update(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public void deleteById(Long id) {
		ocorrenciaRepository.deleteById(id);
	}

}
