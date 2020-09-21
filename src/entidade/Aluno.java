package entidade;

public class Aluno extends Pessoa {
	
	public Aluno(String nome, long matricula) {
		super(nome, matricula);
	}
	
	@Override
	public String toString() {
		return String.format("Aluno: %s\tMatricula: %s", this.getNome(), (int) this.getMatricula());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Aluno)) {
			return false;
		}
		return true;
	}
}
