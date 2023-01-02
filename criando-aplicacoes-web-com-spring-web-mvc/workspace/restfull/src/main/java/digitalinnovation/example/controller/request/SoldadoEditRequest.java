package digitalinnovation.example.controller.request;

public class SoldadoEditRequest {

	private String nome;

	private String raca;

	private String arma;

	public SoldadoEditRequest() {
	}

	public SoldadoEditRequest(String nome, String raca, String arma) {
		this.nome = nome;
		this.raca = raca;
		this.arma = arma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

}
