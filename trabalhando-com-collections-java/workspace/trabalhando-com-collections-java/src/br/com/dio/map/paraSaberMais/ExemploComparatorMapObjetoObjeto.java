package br.com.dio.map.paraSaberMais;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploComparatorMapObjetoObjeto {

	public static void main(String[] args) {
		Aluno aluno2 = new Aluno("Jon", 124);
		Aluno aluno3 = new Aluno("Simba", 125);
		Aluno aluno1 = new Aluno("Camila", 123);

		Disciplina disciplina3 = new Disciplina("Python", 9);
		Disciplina disciplina1 = new Disciplina("Java", 10);
		Disciplina disciplina2 = new Disciplina("JavaScript", 12);

		Map<Disciplina, Aluno> cursos = new HashMap<>();
		cursos.put(disciplina1, aluno1);
		cursos.put(disciplina2, aluno2);
		cursos.put(disciplina3, aluno3);

		System.out.println("Exibindo Dicionário:");
		for (Map.Entry<Disciplina, Aluno> entry : cursos.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("-------\n" + "Nome Disciplina:");
		Map<Disciplina, Aluno> cursos2 = new TreeMap<Disciplina, Aluno>(cursos);
		for (Map.Entry<Disciplina, Aluno> entry : cursos2.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("-------\n" + "Duração Disciplina:");
		Map<Disciplina, Aluno> cursos3 = new TreeMap<Disciplina, Aluno>(new ComparatorDuracaoDisciplina());
		cursos3.putAll(cursos);

		for (Map.Entry<Disciplina, Aluno> entry : cursos3.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("-------\n" + "Nome do Aluno:");
		Set<Map.Entry<Disciplina, Aluno>> set = new TreeSet<Map.Entry<Disciplina, Aluno>>(new ComparatorNomeAluno());
		set.addAll(cursos.entrySet());
		for (Map.Entry<Disciplina, Aluno> entry : set) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("-------\n" + "Matricula do Aluno:");
		Set<Map.Entry<Disciplina, Aluno>> set1 = new TreeSet<Map.Entry<Disciplina, Aluno>>(
				new ComparatorMatriculaAluno());
		set1.addAll(cursos.entrySet());
		for (Map.Entry<Disciplina, Aluno> entry : set1) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}

class ComparatorDuracaoDisciplina implements Comparator<Disciplina> {
	@Override
	public int compare(Disciplina disc1, Disciplina disc2) {
		return Integer.compare(disc1.getDuracao(), disc2.getDuracao());
	}
}

class ComparatorNomeAluno implements Comparator<Map.Entry<Disciplina, Aluno>> {
	@Override
	public int compare(Map.Entry<Disciplina, Aluno> al1, Map.Entry<Disciplina, Aluno> al2) {
		return al1.getValue().getNome().compareToIgnoreCase(al2.getValue().getNome());
	}
}

class ComparatorMatriculaAluno implements Comparator<Map.Entry<Disciplina, Aluno>> {
	@Override
	public int compare(Map.Entry<Disciplina, Aluno> al1, Map.Entry<Disciplina, Aluno> al2) {
		return Integer.compare(al1.getValue().getMatricula(), al2.getValue().getMatricula());
	}

}
