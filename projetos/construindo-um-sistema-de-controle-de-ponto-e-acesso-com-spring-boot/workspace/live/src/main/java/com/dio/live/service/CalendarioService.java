package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;

@Service
public class CalendarioService {

	private CalendarioRepository calendarioRepository;

	public CalendarioService(CalendarioRepository calendarioRepository) {
		this.calendarioRepository = calendarioRepository;
	}

	public Calendario save(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}

	public List<Calendario> findAll() {
		return calendarioRepository.findAll();
	}

	public Optional<Calendario> findById(Long id) {
		return calendarioRepository.findById(id);
	}

	public Calendario update(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}

	public void deleteById(Long id) {
		calendarioRepository.deleteById(id);
	}

}
