package digitalinnovation.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import digitalinnovation.example.model.Soldado;
import digitalinnovation.example.repository.SoldadoRepository;

@SpringBootApplication
public class RestfullApplication implements CommandLineRunner {

	@Autowired
	private SoldadoRepository soldadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfullApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Soldado s1 = new Soldado("Aragorn", "Humano", "Espada");
		Soldado s2 = new Soldado("Legolas", "Elfo", "Arco");
		Soldado s3 = new Soldado("Gandalf", "Humano", "Cajado");
		Soldado s4 = new Soldado("Frodo", "Hobbit", "Espada");
		Soldado s5 = new Soldado("Gimli", "Anão", "Machado");

		soldadoRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
	}

}
