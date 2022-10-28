package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {

	private CategoriaUsuarioRepository categoriaUsuarioRepository;

	public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
		this.categoriaUsuarioRepository = categoriaUsuarioRepository;
	}

	public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}

	public List<CategoriaUsuario> findAll() {
		return categoriaUsuarioRepository.findAll();
	}

	public Optional<CategoriaUsuario> findById(Long id) {
		return categoriaUsuarioRepository.findById(id);
	}

	public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}

	public void deleteById(Long id) {
		categoriaUsuarioRepository.deleteById(id);
	}

}
