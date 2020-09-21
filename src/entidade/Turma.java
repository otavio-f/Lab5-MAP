package entidade;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private Horario horario;
	private List<Aluno> alunos;
	private Disciplina disciplina;
	private Professor professor;
	private long codigo;
	
	public Turma(Disciplina disciplina, Professor professor, Horario horario, long codigo) {;
		this.alunos = new ArrayList<Aluno>();
		this.disciplina = disciplina;
		this.professor = professor;
		this.horario = horario;
		this.codigo = codigo;
	}
	
	public long getCodigo() {
		return this.codigo;
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		String resultado = String.format(
				"Turma %s - %s\tProfessor: %s\tHorario: %s",
				(int) this.codigo,
				this.disciplina.getNome(),
				this.professor.getNome(),
				this.horario
				);
		return resultado;
	}

	public boolean isMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
}
