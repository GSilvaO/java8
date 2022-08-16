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
		
		// Uma das novidade do Java 8 foi a adi��o do m�todo sort em algumas interfaces utilizando
		// um novo recurso chamado default methods
		/*
		 * palavras.sort(comparador); System.out.println(palavras);
		 */
		
		// Ao inv�s de usar o enhanced for para imprimir cada elemento da cole��o, com o java 8 � poss�vel implementar
		// a interface Consumer e passar a implementa��o para o m�todo forEach da pr�pria interface da cole��o, que
		// tamb�m � uma nova funcionalidade 
		//Consumer<String> consumidor = new ImprimeNaLinha();
		
		//palavras.forEach(consumidor);
		
		// Uma outra alternativa � linha 31 e 33 seria implementar uma classe an�nima da seguinte forma
		/*
		 * palavras.forEach(new Consumer<String>(){ public void accept(String palavra) {
		 * System.out.println(palavra); } });
		 */
		
		// O c�digo acima ainda � verboso. Uma das novas features do java 8 s�o as fun��es lambdas. As fun��es
		// lambdas deixam o c�digo mais simples e enxuto. O requisito para a implementa��o de uma fun��o lambda
		// � ter uma INTERFACE FUNCIONAL(interface que possui um m�todo abstrato e pode possuir m�todos default ou static)
		// O metodo abstrato(�nico) � necess�rio para que o compilador saiba que o corpo da express�o lambda � a implementa��o
		// do seu �nico m�todo abstrato
		palavras.forEach(s -> System.out.println(s));
		
		// Implementando um comparator com lambdas
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(),s2.length()));
		
		// Simplificando o c�digo acima utilizando o Comparator.comparing()
		//palavras.sort(Comparator.comparing(s -> s.length());
		
		// Simplificando o c�digo acima utilizando o method reference
		//palavras.sort(Comparator.comparing(String::length));
		
		// Implementando a partir do import est�tico do m�todo comparing
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

// Maneira de fazer uma compara��o customizada antes do Java 8.
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