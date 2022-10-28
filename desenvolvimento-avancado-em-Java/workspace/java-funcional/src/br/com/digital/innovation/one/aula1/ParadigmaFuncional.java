package br.com.digital.innovation.one.aula1;

import java.util.function.Function;

public class ParadigmaFuncional {

	public static void main(String[] args) {
		
		// Paradigma funcional
//		UnaryOperator<Integer> calcularValorVezes3 = valor -> valor * 30;
//		int valor = 10;
//		System.out.println("O resultado é :: " + calcularValorVezes3.apply(valor));
		
		// Composição de funções
//		int[] valores = {1,2,3,4};
//		
//		Arrays.stream(valores)
//			.filter(numero -> numero % 2 == 0)
//			.map(numero -> numero * 2)
//			.forEach(numero -> System.out.println(numero));
		
		// Funções puras
//		BiPredicate<Integer, Integer> verificarSeEMaior = 
//				(parametro, valorComparacao) -> parametro > valorComparacao;
//				
//		System.out.println(verificarSeEMaior.test(13, 12));
//		System.out.println(verificarSeEMaior.test(13, 12));
		
		// Imutabilidade
//		int valor = 20;
//		UnaryOperator<Integer> retornarDobro = v -> v * 2;
//		System.out.println(retornarDobro.apply(valor));
//		System.out.println(valor);
		
		//
//		Function<Integer, Object> buscarUsuario = idUsuario -> new Object();
//		System.out.println(buscarUsuario.apply(15));
		
		// Lambda
		// InterfaceFuncional nomeVariavel = parametro -> logica
		
//		Funcao funcao = valor -> valor;
//		System.out.println(funcao.gerar("aaa"));
//		
//		Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
//		System.out.println(colocarPrefixoSenhorNaString.gerar("Joao"));
		
//		Funcao funcao1 = valor -> {
//			return valor;
//		};
//		System.out.println(funcao1.gerar("test"));
		
		// Recursividade
		System.out.println(fatorialA(5));
		
		
		System.out.println(System.nanoTime());
	}
	
	public static double fatorialA(double valor) {
		return fatorialComTailCall(valor, 1);
	}
	
	public static double fatorialComTailCall(double valor, double numero) {
		if (valor == 0) {
			return numero;
		}
		return fatorialComTailCall(valor - 1, numero * valor);
	}
	
	@FunctionalInterface
	interface Funcao {
		String gerar(String valor);
	}
	
//	@FunctionalInterface
//	interface Funcao {
//		void gerar(String valor);
//	}

}
