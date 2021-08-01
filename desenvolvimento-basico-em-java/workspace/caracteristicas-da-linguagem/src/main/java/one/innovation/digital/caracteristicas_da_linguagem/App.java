package one.innovation.digital.caracteristicas_da_linguagem;

import java.util.stream.IntStream;

public class App {

	//https://github.com/andrelugomes/digital-innovation-one
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
//		var x = 1;
//		
//		var y = "1";
//		
//		System.out.println("O número é: " + x + y);
//		
//		System.out.println(" ${x}");
//		
//		
//		System.out.println("A B C D E F G".toCharArray());
//		System.out.println("Aula de Java".split(" "));
//		System.out.println("Aula".concat(" de Java"));
//		System.out.println("1234 asda qw".replaceAll("[0-9]", "#"));
		
		
		IntStream.of(1,2,3,4,5).forEach(n -> {
			System.out.println(n);
		});
		
		IntStream.range(0, 3).forEach(n -> {
			System.out.println("Número: " + n);
		});
		
		
	}

}
