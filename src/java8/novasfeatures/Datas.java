package java8.novasfeatures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate agora = LocalDate.now();
		LocalDate futuro = LocalDate.of(2099, Month.JANUARY, 25);
		Period periodo = Period.between(agora, futuro);
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAtualFormatada = agora.format(dataFormatada);
		System.out.println(agora);
		System.out.println(futuro);
		System.out.println(periodo);
		System.out.println(dataAtualFormatada);
	}
}
