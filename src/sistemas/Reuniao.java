package sistemas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reuniao {
	private LocalDateTime horario;
	private String assunto;
	
	public Reuniao(String assunto, int ano, int mes, int dia, int hora, int minuto) {
		this.horario = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}
	
	public Reuniao(String assunto, String data, String hora) {
		this.assunto = assunto;
		this.horario = LocalDateTime.of(
				LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"))
				);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Reunião marcada dia %s às %s sobre o assunto \"%s\"",
				horario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				horario.format(DateTimeFormatter.ofPattern("HH:mm")),
				this.assunto
				);
	}
}
