package br.com.digital.innovation.one.aula6;

import java.util.function.Function;

public class InferenciaLambda {
	
	public static void main(String[] args) {
		// Utilizar var dentro da Lambda, a partir do Java 11
		Function<Integer, Double> divisaoPor2 = (var numero) -> numero / 2.0;
		System.out.println(divisaoPor2.apply(123));
		
		
		
		
		
	}

}
