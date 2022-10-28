package br.com.digital.innovation.one.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExemplo {
	private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException {
		Casa casa = new Casa(new Quarto());
		
//		List<? extends Future<?>> futuros = casa.obterAfazeresDaCasa().stream()
//			.map(atividade -> pessoasParaExecutarAtividade.submit(atividade::realizar))
//			.collect(Collectors.toList());
		
		// Thread Safe
		List<? extends Future<String>> futuros = 
		new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
				.map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
						try {
							return atividade.realizar();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						return null;
					})
				)
				.collect(Collectors.toList()));
		
//		while (!futuros.stream().allMatch(Future::isDone)) {
		while (true) {
			int numeroDeAtividadesNaoFinalizadas = 0;

			for (Future<?> futuro : futuros) {
				if (futuro.isDone()) {
					try {
						System.out.println("Parabens voce terminou de " + futuro.get());
						futuros.remove(futuro);
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				} else {
					numeroDeAtividadesNaoFinalizadas++;
				}
			}
			
			if (futuros.stream().allMatch(Future::isDone)) {
				break;
			}
			
			System.out.println("Numero de atividades nao finalizadas :: " + numeroDeAtividadesNaoFinalizadas);
			Thread.sleep(500);
		}
		
		pessoasParaExecutarAtividade.shutdown();
	}

}

class Casa {
	private List<Comodo> comodos;

	Casa(Comodo... comodos) {
		this.comodos = Arrays.asList(comodos);
	}

	List<Atividade> obterAfazeresDaCasa() {
		return this.comodos.stream().map(Comodo::obterAfazeresDoComodo).reduce(new ArrayList<Atividade>(),
				(pivo, atividades) -> {
					pivo.addAll(atividades);
					return pivo;
				});

	}
}

interface Atividade {
	String realizar() throws InterruptedException;
}

abstract class Comodo {
	abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

	@Override
	List<Atividade> obterAfazeresDoComodo() {
		return Arrays.asList(
				this::arrumarCama, 
				this::varrerOQuarto, 
				this::arrumarGuardaRoupa
		);
	}

	private String arrumarGuardaRoupa() throws InterruptedException {
		Thread.sleep(5000);
		String arrumarOGuardaRoupa = "Arrumar o guarda roupa";
		System.out.println(arrumarOGuardaRoupa);
		return arrumarOGuardaRoupa;
	}

	private String varrerOQuarto() throws InterruptedException {
		Thread.sleep(7000);
		String varrerOQuarto = "Varrer o quarto";
		System.out.println(varrerOQuarto);
		return varrerOQuarto;
	}

	private String arrumarCama() throws InterruptedException {
		Thread.sleep(10000);
		String arrumarACama = "Arrumar a cama";
		System.out.println(arrumarACama);
		return arrumarACama;
	}

}
