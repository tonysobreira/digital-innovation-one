package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;

@Service
public class EmpresaService {

	private EmpresaRepository empresaRepository;

	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public Optional<Empresa> findById(Long id) {
		return empresaRepository.findById(id);
	}

	public Empresa update(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void deleteById(Long id) {
		empresaRepository.deleteById(id);
	}

}
