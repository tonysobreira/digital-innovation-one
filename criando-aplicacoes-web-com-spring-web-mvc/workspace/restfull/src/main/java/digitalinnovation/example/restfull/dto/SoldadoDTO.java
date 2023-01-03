package digitalinnovation.example.restfull.dto;

import digitalinnovation.example.restfull.enums.Raca;

public class SoldadoDTO {

	private Long id;

	private String nome;

	private Raca raca;

	private String arma;

	private String status;

	public SoldadoDTO() {
	}

	public SoldadoDTO(String nome, Raca raca, String arma, String status) {
		this.nome = nome;
		this.raca = raca;
		this.arma = arma;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
