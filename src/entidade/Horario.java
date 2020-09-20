package entidade;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Horario {
	private DayOfWeek dia;
	private LocalTime hora;
	
	public Horario(DayOfWeek dia, int hora, int minuto) {
		this.hora = LocalTime.of(hora, minuto);
		this.dia = dia;
	}
	
	public Horario(DayOfWeek dia, String hora) {
		this.hora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
		this.dia = dia;
	}
	
	public DayOfWeek getDia() {
		return dia;
	}
	
	public void setDia(DayOfWeek dia) {
		this.dia = dia;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(int hora, int minuto) {
		this.hora = LocalTime.of(hora, minuto);
	}
	
	public void setHora(String hora) {
		this.hora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
	}

}
