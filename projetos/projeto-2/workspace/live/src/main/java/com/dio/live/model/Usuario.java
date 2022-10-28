package com.dio.live.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private CategoriaUsuario categoriaUsuario;
	private String nome;
	@ManyToOne
	private Empresa empresa;
	@ManyToOne
	private NivelAcesso nivelAcesso;
	@ManyToOne
	private JornadaTrabalho jornadaTrabalho;
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime finalJornada;
}
