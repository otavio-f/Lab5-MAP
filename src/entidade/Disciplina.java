package entidade;

public class Disciplina {
	private String nome;
	private long codigo;
	
	public Disciplina(String nome, long codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return String.format("Disciplina: %s\tCódigo: %s", nome, (int) codigo);
	}

}
