package com.dio.live.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BancoHorasId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idBancoHoras;
	private Long idMovimentacao;
	private Long idUsuario;
}
