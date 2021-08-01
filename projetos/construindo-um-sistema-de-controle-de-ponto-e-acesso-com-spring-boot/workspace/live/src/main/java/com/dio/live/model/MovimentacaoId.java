package com.dio.live.model;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class MovimentacaoId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idMovimento;
	private Long idUsuario;
}
