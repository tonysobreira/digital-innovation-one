package br.com.digital.innovation.one.aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfacesFuncionais {

	public static void main(String[] args) {
		// Funcao alta ordem
//		Calculo soma = (a, b) -> a + b;
//		Calculo subtracao = (a, b) -> a - b;
//		Calculo divisao = (a, b) -> a / b;
//		Calculo mult = (a, b) -> a * b;
//
//		System.out.println(executarOperacao(soma, 1, 3));
//		System.out.println(executarOperacao(subtracao, 4, 3));
//		System.out.println(executarOperacao(divisao, 4, 2));
//		System.out.println(executarOperacao(mult, 7, 3));
		
		
		// Consumidores
//		Consumer<String> imprimirUmaFrase = System.out::println;
//		Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
//		imprimirUmaFrase.accept("Hello World");
		
		
		// Funcoes
//		Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
//		Function<String, Integer> converterStringParaInteiroECalcularODobro = string -> Integer.valueOf(string) * 2;
		
		// Method reference
//		Function<String, Integer> converterStringParaInteiroECalcularODobro = Integer::valueOf;
		
//		Function<String, Integer> converterStringParaInteiroECalcularODobro = string -> {
//			return Integer.valueOf(string) * 2;
//		};
		
//		System.out.println(retornarNomeAoContrario.apply("joao"));
//		System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));
		
		
		// Predicados
//		Predicate<String> estaVazio = valor -> valor.isEmpty();
		// method reference
//		Predicate<String> estaVazio = String::isEmpty;
//		Predicate<String> isNull = valor -> valor == null;
//		System.out.println(estaVazio.test(""));
//		System.out.println(estaVazio.test("Joao"));
//		
//		System.out.println(isNull.test(null));
		
		
		// Suppliers
//		Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
//		Supplier<Pessoa> instanciaPessoa2 = Pessoa::new;
//		System.out.println(instanciaPessoa.get());
//		System.out.println(instanciaPessoa2.get());
		
		
		// Iteracoes
		String[] nomes = {"Joao", "Joao", "Paulo", "Oliveira", "Instrutor", "Java"};
		Integer[] numeros = {1,2,3,4,5};
//		imprimirNomesFiltrados(nomes);
//		imprimirTodosOsNomes(nomes);
//		imprimirODobroDeCadaItemDaList(numeros);
		
		List<String> profissoes = new ArrayList<>();
		profissoes.add("Desenvolvedor");
		profissoes.add("Testador");
		profissoes.add("Gerente de Projeto");
		profissoes.add("Gerente de Qualidade");
		
		profissoes.stream()
			.filter(profissao -> profissao.startsWith("Gerente"))
			.forEach(System.out::println);
		
		List<String> lista2 = profissoes.stream()
			.filter(profissao -> profissao.startsWith("Des"))
			.collect(Collectors.toList());
		
		lista2.stream().forEach(System.out::println);
	}
	
	public static void imprimirODobroDeCadaItemDaList(Integer... numeros) {
		Stream.of(numeros)
			.map(numero -> numero * 2)
			.forEach(System.out::println);
	}

	public static void imprimirNomesFiltrados(String... nomes) {
		String nomesResultados = Stream.of(nomes)
				.filter(nome -> nome.equals("Joao"))
				.collect(Collectors.joining(" - ")); // transforma array de String em uma String
		System.out.println(nomesResultados);
	}
	
	public static void imprimirTodosOsNomes(String... nomes) {
//		for (String nome : nomes) {
//			System.out.println(nome);
//		}
//		
		Stream.of(nomes)
			.forEach(System.out::println);
//		
//		Stream.of(nomes)
//			.forEach(nome -> System.out.println(nome));
	}

	// Recebendo outra funcao como parametro
	public static int executarOperacao(Calculo calculo, int a, int b) {
		return calculo.calculo(a, b);
	}

}

class Pessoa {
	private String nome;
	private Integer idade;
	
	public Pessoa() {
		nome = "joao";
		idade = 23;
	}

	@Override
	public String toString() {
		return String.format("nome: %s, idade: %d", nome, idade);
	}
	
}

@FunctionalInterface
interface Calculo {
	public int calculo(int a, int b);
}