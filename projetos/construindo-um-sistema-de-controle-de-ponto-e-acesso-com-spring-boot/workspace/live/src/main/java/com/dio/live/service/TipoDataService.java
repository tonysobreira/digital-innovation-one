package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;

@Service
public class TipoDataService {

	private TipoDataRepository tipoDataRepository;

	public TipoDataService(TipoDataRepository tipoDataRepository) {
		this.tipoDataRepository = tipoDataRepository;
	}

	public TipoData save(TipoData tipoData) {
		return tipoDataRepository.save(tipoData);
	}

	public List<TipoData> findAll() {
		return tipoDataRepository.findAll();
	}

	public Optional<TipoData> findById(Long id) {
		return tipoDataRepository.findById(id);
	}

	public TipoData update(TipoData tipoData) {
		return tipoDataRepository.save(tipoData);
	}

	public void deleteById(Long id) {
		tipoDataRepository.deleteById(id);
	}

}
