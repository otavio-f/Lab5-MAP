package sistemas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorarioMarcado {
	private LocalDateTime horario;
	
	public HorarioMarcado(int ano, int mes, int dia, int hora, int minuto) {
		this.horario = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}
	
	public HorarioMarcado(String data, String hora) {
		this.horario = LocalDateTime.of(
				LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"))
				);
	}
	
	@Override
	public String toString() {
		return String.format(
				"dia %s às %s",
				horario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				horario.format(DateTimeFormatter.ofPattern("HH:mm"))
				);
	}

}
