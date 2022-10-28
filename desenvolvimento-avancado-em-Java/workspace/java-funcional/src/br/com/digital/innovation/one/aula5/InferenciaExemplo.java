package br.com.digital.innovation.one.aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class InferenciaExemplo {

	public static void main(String[] args) {
//		URL url = new URL("https://docs.oracle.com/javase/10/language/");
//		URLConnection urlConnection = url.openConnection();
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//		System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
		
//		printarNomeCompleto("Joao", "Santos");
//		printarSoma(5, 5, 5);
		
		connectAndPrintURLJavaOracle();
	}

	private static void connectAndPrintURLJavaOracle() {
//		var url = new URL("https://docs.oracle.com/javase/10/language/");
//		var urlConnection = url.openConnection();
//		var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//		System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
		
		
		// try with resource
		try {
			var url = new URL("https://docs.oracle.com/javase/10/language/");
			var urlConnection = url.openConnection();
			
			try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
				System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void printarNomeCompleto(String nome, String sobreNome) {
		var nomeCompleto = String.format("%s %s", nome, sobreNome);
		System.out.println(nomeCompleto);
	}
	
	public static void printarSoma(int... numeros) {
		int soma;

		if (numeros.length > 0) {
			soma = 0;

//			for (var numero : numeros) {
//				soma += numero;
//			}
			
			for (var i = 0; i < numeros.length; i++) {
				soma += numeros[i];
			}

			System.out.println("A soma e :: " + soma);
		}

	}
	
	// consegue
	// variaveis locais inicializadas
	// variavel suporte do enhanced for
	// variavel suporte do for iterativo	
	// variavel try with resource
	
	
	
	// nao consegue
	// var nao pode ser utilizado em nivel de classe
	// var nao pode ser utilizado como parametro
	// var nao pode ser utilizado em variaveis locais nao inicializadas
	
	
	// https://docs.oracle.com/javase/10/language/
	
	
}
