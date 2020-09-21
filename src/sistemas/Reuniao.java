package sistemas;

public class Reuniao {
	private HorarioMarcado horario;
	private String assunto;
	
	public Reuniao(String assunto, int ano, int mes, int dia, int hora, int minuto) {
		this.horario = new HorarioMarcado(ano, mes, dia, hora, minuto);
		this.assunto = assunto;
	}
	
	public Reuniao(String assunto, String data, String hora) {
		this.assunto = assunto;
		this.horario = new HorarioMarcado(data, hora);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Reunião marcada %s sobre o assunto \"%s\"",
				horario.toString(),
				this.assunto
				);
	}
}
