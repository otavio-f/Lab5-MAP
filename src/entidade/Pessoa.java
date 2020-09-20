package entidade;

/***
 * Classe que representa uma pessoa participante do sistema
 * @author otavi
 *
 */
public class Pessoa {
	private String nome;
	private long matricula;
	
	public Pessoa(String nome, long matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

}
