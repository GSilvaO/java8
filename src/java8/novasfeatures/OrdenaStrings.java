package java8.novasfeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public class OrdenaStrings {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("batata");
		palavras.add("cenoura");
		palavras.add("alface");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras, comparador);
		
		// Uma das novidade do Java 8 foi a adição do método sort em algumas interfaces utilizando
		// um novo recurso chamado default methods
		/*
		 * palavras.sort(comparador); System.out.println(palavras);
		 */
		
		// Ao invés de usar o enhanced for para imprimir cada elemento da coleção, com o java 8 é possível implementar
		// a interface Consumer e passar a implementação para o método forEach da própria interface da coleção, que
		// também é uma nova funcionalidade 
		//Consumer<String> consumidor = new ImprimeNaLinha();
		
		//palavras.forEach(consumidor);
		
		// Uma outra alternativa à linha 31 e 33 seria implementar uma classe anônima da seguinte forma
		/*
		 * palavras.forEach(new Consumer<String>(){ public void accept(String palavra) {
		 * System.out.println(palavra); } });
		 */
		
		// O código acima ainda é verboso. Uma das novas features do java 8 são as funções lambdas. As funções
		// lambdas deixam o código mais simples e enxuto. O requisito para a implementação de uma função lambda
		// é ter uma INTERFACE FUNCIONAL(interface que possui um método abstrato e pode possuir métodos default ou static)
		// O metodo abstrato(único) é necessário para que o compilador saiba que o corpo da expressão lambda é a implementação
		// do seu único método abstrato
		palavras.forEach(s -> System.out.println(s));
		
		// Implementando um comparator com lambdas
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(),s2.length()));
		
		// Simplificando o código acima utilizando o Comparator.comparing()
		//palavras.sort(Comparator.comparing(s -> s.length());
		
		// Simplificando o código acima utilizando o method reference
		//palavras.sort(Comparator.comparing(String::length));
		
		// Implementando a partir do import estático do método comparing
		palavras.sort(comparing(String::length));
		
		palavras.forEach(System.out::println);
	}
}


class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);		
	}
}

// Maneira de fazer uma comparação customizada antes do Java 8.
class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}