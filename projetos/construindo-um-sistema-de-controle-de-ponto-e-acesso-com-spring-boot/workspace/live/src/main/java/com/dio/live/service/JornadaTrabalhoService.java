package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {

	private JornadaTrabalhoRepository jornadaTrabalhoRepository;

	public JornadaTrabalhoService(JornadaTrabalhoRepository jornadaTrabalhoRepository) {
		this.jornadaTrabalhoRepository = jornadaTrabalhoRepository;
	}

	public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaTrabalhoRepository.findAll();
	}

	public Optional<JornadaTrabalho> findById(Long id) {
		return jornadaTrabalhoRepository.findById(id);
	}

	public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}

	public void deleteById(Long id) {
		jornadaTrabalhoRepository.deleteById(id);
	}

}
