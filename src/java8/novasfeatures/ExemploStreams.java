package java8.novasfeatures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploStreams {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// Ordenando e printando os cursos
		//cursos.sort(Comparator.comparing(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		// Filtrando e printando os cursos que possuem mais de 100 alunos
		//cursos.stream()
		//	.filter(c -> c.getAlunos() > 50)
		//	.forEach(c -> System.out.println(c.getNome()));
		
		// Transformando uma stream de cursos em uma stream de strings
		List<String> nomeCursos = cursos.stream().map(Curso::getNome).collect(Collectors.toList());
		nomeCursos.forEach(System.out::println);
		
		// Pegando o primeir curso com mais de 50 alunos
		Curso primeiroCurso = cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.findFirst()
			.get();
		
		System.out.println(primeiroCurso.getNome());
		
		// Calculando a média de alunos
		OptionalDouble average = cursos.stream().mapToDouble(Curso::getAlunos).average();
		System.out.println(average.getAsDouble());
	}
}
