package entidade;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Horario {
	public enum Dia{
		SEGUNDA("segunda"), TERCA("terça"), QUARTA("quarta"), QUINTA("quinta"), SEXTA("sexta"), SABADO("sábado"), DOMINGO("domingo");
		private String val;
		
		Dia(String val) {
			this.val = val;
		}
		
		public String getVal() {
			return this.val;
		}
	}
	
	private Dia dia;
	private LocalTime hora;
	
	public Horario(Dia dia, int hora, int minuto) {
		this.hora = LocalTime.of(hora, minuto);
		this.dia = dia;
	}
	
	public Horario(Dia dia, String hora) {
		this.hora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
		this.dia = dia;
	}
	
	public Dia getDia() {
		return dia;
	}
	
	public void setDia(Dia dia) {
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
	
	@Override
	public String toString() {
		return String.format(
				"%s - %s",
				dia.getVal(),
				this.hora.format(DateTimeFormatter.ofPattern("HH:mm"))
				);
	}

}
