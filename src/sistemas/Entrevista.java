package sistemas;

public class Entrevista {
	private HorarioMarcado horario;
	private String nome;
	
	public Entrevista(String nome, int ano, int mes, int dia, int hora, int minuto) {
		this.horario = new HorarioMarcado(ano, mes, dia, hora, minuto);
		this.nome = nome;
	}
	
	public Entrevista(String nome, String data, String hora) {
		this.nome = nome;
		this.horario = new HorarioMarcado(data, hora);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Entrevista marcada %s com %s",
				horario.toString(),
				this.nome
				);
	}

}
