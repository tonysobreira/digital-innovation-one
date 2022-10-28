package br.com.dio.map.paraSaberMais;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExemploComparatorMapObjetoSet {

	public static void main(String[] args) {
		Aluno aluno2 = new Aluno("Jon", 124);
		Aluno aluno3 = new Aluno("Simba", 125);
		Aluno aluno1 = new Aluno("Camila", 123);

		Disciplina disc3 = new Disciplina("Python", 9);
		Disciplina disc1 = new Disciplina("Java", 10);
		Disciplina disc2 = new Disciplina("JavaScript", 12);

		Set<Disciplina> disciplinas1 = new HashSet<Disciplina>(Arrays.asList(disc1, disc2));
		Set<Disciplina> disciplinas2 = new HashSet<Disciplina>(Arrays.asList(disc2, disc3));
		Set<Disciplina> disciplinas3 = new HashSet<Disciplina>(Arrays.asList(disc1, disc3));

		Map<Aluno, Set<Disciplina>> alunosEDisciplinas = new HashMap<Aluno, Set<Disciplina>>();
		alunosEDisciplinas.put(aluno1, disciplinas1);
		alunosEDisciplinas.put(aluno2, disciplinas2);
		alunosEDisciplinas.put(aluno3, disciplinas3);

		// System.out.println(alunosEDisciplinas);
		System.out.println("Exibindo Dicion�rio:");
		for (Map.Entry<Aluno, Set<Disciplina>> entry : alunosEDisciplinas.entrySet()) {
			System.out.print(entry.getKey().getNome() + " - " + entry.getKey().getMatricula() + ": ");
			for (Disciplina entry1 : entry.getValue()) {
				System.out.print(entry1.getNome() + " ");
			}
			System.out.println();
		}
	}

}