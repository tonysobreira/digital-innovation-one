package br.com.dio.map.exercicioProposto03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExercicioProposto03 {

	public static void main(String[] args) {
		System.out.println("--\tOrdem aleat�ria\t--");
		Map<Integer, Contato> agenda = new HashMap<>();
		agenda.put(1, new Contato("Simba", 5555));
		agenda.put(4, new Contato("Cami", 1111));
		agenda.put(3, new Contato("Jon", 2222));
		System.out.println(agenda);
		for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}

		System.out.println("--\tOrdem Inser��o\t--");
		Map<Integer, Contato> agenda1 = new LinkedHashMap<>();
		agenda1.put(1, new Contato("Simba", 5555));
		agenda1.put(4, new Contato("Cami", 1111));
		agenda1.put(3, new Contato("Jon", 2222));
		System.out.println(agenda1);
		for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}

		System.out.println("--\tOrdem id\t--");
		Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
		System.out.println(agenda2);
		for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}

		System.out.println("--\tOrdem n�mero telefone\t--");
		// precisamos organizar os valores. Logo:
		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new ComparatorOrdemNumerica());
		set.addAll(agenda.entrySet());
		for (Map.Entry<Integer, Contato> entry : set) {
			System.out
					.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
		}

		System.out.println("--\tOrdem nome contato\t--");
		// precisamos organizar os valores. Logo:
		Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());
		set1.addAll(agenda.entrySet());
		for (Map.Entry<Integer, Contato> entry : set1) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}
	}
}

class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
	@Override
	public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
		return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
	}
}

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
	@Override
	public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
		return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
	}

}
