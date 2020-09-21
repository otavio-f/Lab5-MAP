package entidade;

public class Professor extends Pessoa {

	public Professor(String nome, long matricula) {
		super(nome, matricula);
	}

	@Override
	public String toString() {
		return String.format("Professor: %s\tMatricula: %s", this.getNome(), (int) this.getMatricula());
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
		if (!(obj instanceof Professor)) {
			return false;
		}
		return true;
	}
}
