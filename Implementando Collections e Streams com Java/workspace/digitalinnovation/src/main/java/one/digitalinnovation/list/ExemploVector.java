package one.digitalinnovation.list;

import java.util.List;
import java.util.Vector;

public class ExemploVector {

	public static void main(String[] args) {

		// Thread-safe
		// Aumenta o dobro do ArrayList (Melhor performance)
		List<String> esportes = new Vector<>();

		esportes.add("Futebol");
		esportes.add("Basquetebol");
		esportes.add("Tênis de Mesa");
		esportes.add("Handebol");

		System.out.println(esportes);

		esportes.set(2, "Ping Pong");

		esportes.remove(2);

		esportes.remove("Handebol");

		System.out.println(esportes);

		System.out.println(esportes.get(0));

		for (String esporte : esportes) {
			System.out.println(esporte);
		}

	}

}
