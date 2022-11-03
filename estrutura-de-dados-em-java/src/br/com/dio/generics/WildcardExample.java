package br.com.dio.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardExample {
	
	/**
	 * Convenção
	 * K - Key
	 * V - Value
	 * E - Element
	 * T - Type
	 * ? - Genérico
	 * 
	 */

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		imprimeLista(nums);
		
		List<String> listStr = Arrays.asList("a", "b", "c");
		imprimeLista(listStr);
		
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa(1L, "aaaa"));
//		imprimeLista2(listStr);
		imprimeLista2(pessoas);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(1L, "aaaa", "1234"));
		
//		imprimeLista3(alunos);
		imprimeLista3(pessoas);
		imprimeLista(alunos);
 
	}

	// Unknown Wildcard
	public static void imprimeLista(List<?> lista) {
		for (Object obj : lista) {
			System.out.println(obj);
		}
	}

	// UpperBounded Wildcard
	public static void imprimeLista2(List<? extends Pessoa> lista) {
		for (Pessoa p : lista) {
			System.out.println(p);
		}
	}
	
	// LowerBounded Wildcard
	public static void imprimeLista3(List<? super Pessoa> lista) {
		for (Object p : lista) {
			System.out.println(p);
		}
	}

}
