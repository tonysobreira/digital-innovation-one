package com.dio.live.model;

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
public class Calendario {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private TipoData tipoData;
	private String descricao;
	private LocalDateTime dataEspecial;
}
