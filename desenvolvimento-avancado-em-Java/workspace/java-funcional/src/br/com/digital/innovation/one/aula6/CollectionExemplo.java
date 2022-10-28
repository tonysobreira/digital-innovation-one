package br.com.digital.innovation.one.aula6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionExemplo {
	
	public static void main(String[] args) {
//		List<String> nomes = Arrays.asList("Joao", "Paulo", "Oliveira", "Santos");
//		System.out.println(nomes);
		
//		Collection<String> nomes = List.of("Joao", "Paulo", "Oliveira", "Santos");
		Collection<String> nomes = Set.of("Joao", "Paulo", "Oliveira", "Santos", "Santos");
		System.out.println(nomes);
		
	}

}
