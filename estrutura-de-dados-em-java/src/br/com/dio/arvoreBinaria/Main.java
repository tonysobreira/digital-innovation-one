package br.com.dio.arvoreBinaria;

import br.com.dio.arvoreBinaria.model.Obj;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

		minhaArvore.inserir(new Obj(13));
		
//		Obj obj10 = new Obj(10);
//		minhaArvore.inserir(obj10);
		
		minhaArvore.inserir(new Obj(10));
		
		minhaArvore.inserir(new Obj(25));
		minhaArvore.inserir(new Obj(2));
		minhaArvore.inserir(new Obj(12));
		minhaArvore.inserir(new Obj(20));
		minhaArvore.inserir(new Obj(31));
		minhaArvore.inserir(new Obj(29));

		minhaArvore.exibirInOrdem();
		minhaArvore.exibirPreOrdem();
		minhaArvore.exibirPosOrdem();

		System.out.println("\n\n-----");

		Obj obj32 = new Obj(32);
		minhaArvore.inserir(obj32);

		minhaArvore.exibirInOrdem();
		minhaArvore.exibirPreOrdem();
		minhaArvore.exibirPosOrdem();

		System.out.println("\n\n-----");

		minhaArvore.remover(obj32);
//		minhaArvore.remover(obj10);

		minhaArvore.exibirInOrdem();
		minhaArvore.exibirPreOrdem();
		minhaArvore.exibirPosOrdem();

	}

}
