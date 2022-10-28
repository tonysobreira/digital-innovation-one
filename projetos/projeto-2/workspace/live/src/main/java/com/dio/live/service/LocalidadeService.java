package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;

@Service
public class LocalidadeService {

	private LocalidadeRepository localidadeRepository;

	public LocalidadeService(LocalidadeRepository localidadeRepository) {
		this.localidadeRepository = localidadeRepository;
	}

	public Localidade save(Localidade localidade) {
		return localidadeRepository.save(localidade);
	}

	public List<Localidade> findAll() {
		return localidadeRepository.findAll();
	}

	public Optional<Localidade> findById(Long id) {
		return localidadeRepository.findById(id);
	}

	public Localidade update(Localidade localidade) {
		return localidadeRepository.save(localidade);
	}

	public void deleteById(Long id) {
		localidadeRepository.deleteById(id);
	}

}
