package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;

@Service
public class BancoHorasService {

	private BancoHorasRepository bancoHorasRepository;

	public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
		this.bancoHorasRepository = bancoHorasRepository;
	}

	public BancoHoras save(BancoHoras bancoHoras) {
		return bancoHorasRepository.save(bancoHoras);
	}

	public List<BancoHoras> findAll() {
		return bancoHorasRepository.findAll();
	}

	public Optional<BancoHoras> findById(Long id) {
		return bancoHorasRepository.findById(id);
	}

	public BancoHoras update(BancoHoras bancoHoras) {
		return bancoHorasRepository.save(bancoHoras);
	}

	public void deleteById(Long id) {
		bancoHorasRepository.deleteById(id);
	}

}
