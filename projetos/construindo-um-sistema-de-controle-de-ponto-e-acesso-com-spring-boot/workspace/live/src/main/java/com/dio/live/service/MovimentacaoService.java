package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	private MovimentacaoRepository movimentacaoRepository;

	public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
		this.movimentacaoRepository = movimentacaoRepository;
	}

	public Movimentacao save(Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}

	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}

	public Optional<Movimentacao> findById(Long id) {
		return movimentacaoRepository.findById(id);
	}

	public Movimentacao update(Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}

	public void deleteById(Long id) {
		movimentacaoRepository.deleteById(id);
	}

}
