package br.com.digital.innovation.one.aula3;

public class ThreadExemplo {

	public static void main(String[] args) {
//		BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
//		BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
//		barraDeCarregamento2.start();
//		barraDeCarregamento3.start();
//		barraDeCarregamento2.run();
//		barraDeCarregamento3.run();

//		Thread thread = new Thread(new BarraDeCarregamento2());
//		Thread thread2 = new Thread(new BarraDeCarregamento3());
//		thread.start();
//		thread2.start();
//		System.out.println("Nome da thread: " + thread.getName());
//		System.out.println("Nome da thread: " + thread2.getName());

		GeradorPDF iniciarGeradorPdf = new GeradorPDF();
		BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);

		iniciarGeradorPdf.start();
		barraDeCarregamento.start();

	}

}

class GeradorPDF extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Iniciar geração de PDF");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PDF gerado");
	}
}

class BarraDeCarregamento extends Thread {

	private Thread iniciarGeradorPdf;

	public BarraDeCarregamento(Thread iniciarGeradorPdf) {
		this.iniciarGeradorPdf = iniciarGeradorPdf;
	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(500);

				if (!iniciarGeradorPdf.isAlive()) {
					break;
				}

				System.out.println("Loading ... ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}

class BarraDeCarregamento2 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("Rodei BarraDeCarregamento2 : ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BarraDeCarregamento3 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Rodei BarraDeCarregamento3 : ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// Outra Forma
class BarraDeCarregamento4 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(1000);
			System.out.println("Nome da Thread : " + this.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
