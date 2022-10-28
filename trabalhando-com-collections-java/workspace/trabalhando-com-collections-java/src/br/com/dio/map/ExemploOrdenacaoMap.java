package br.com.dio.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {

	public static void main(String[] args) {

		System.out.println("--\tOrdem aleat�ria\t--");
		Map<String, Livro> meusLivros = new HashMap<>();
		meusLivros.put(" Hawking, Stephen", new Livro("Uma Breve Hist�ria do Tempo", 256));
		meusLivros.put(" Duhigg, Charles", new Livro("O Poder do H�bito", 408));
		meusLivros.put(" Harari, Yuval Noah", new Livro("21 Li��es Para o S�culo 21", 432));
		for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

		System.out.println("--\tOrdem Inser��o\t--");
		Map<String, Livro> meusLivros1 = new LinkedHashMap<>();
		meusLivros1.put(" Hawking, Stephen", new Livro("Uma Breve Hist�ria do Tempo", 256));
		meusLivros1.put(" Duhigg, Charles", new Livro("O Poder do H�bito", 408));
		meusLivros1.put(" Harari, Yuval Noah", new Livro("21 Li��es Para o S�culo 21", 432));
		for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

		System.out.println("--\tOrdem alfab�tica autores\t--");
		Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

		System.out.println("--\tOrdem alfab�tica nomes dos livros\t--");

		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		meusLivros3.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livro : meusLivros3)
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

		// System.out.println("--\tOrdem n�mero de p�gina\t--"); //Pra voc�

	}
}
