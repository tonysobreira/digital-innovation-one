package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {

	private NivelAcessoRepository nivelAcessoRepository;

	public NivelAcessoService(NivelAcessoRepository NivelAcessoRepository) {
		this.nivelAcessoRepository = NivelAcessoRepository;
	}

	public NivelAcesso save(NivelAcesso NivelAcesso) {
		return nivelAcessoRepository.save(NivelAcesso);
	}

	public List<NivelAcesso> findAll() {
		return nivelAcessoRepository.findAll();
	}

	public Optional<NivelAcesso> findById(Long id) {
		return nivelAcessoRepository.findById(id);
	}

	public NivelAcesso update(NivelAcesso NivelAcesso) {
		return nivelAcessoRepository.save(NivelAcesso);
	}

	public void deleteById(Long id) {
		nivelAcessoRepository.deleteById(id);
	}

}
