package entidade;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private Horario horario;
	private List<Aluno> alunos;
	private Disciplina disciplina;
	private Professor professor;
	private String sala;
	private long codigo;
	
	public Turma(Disciplina disciplina, Professor professor, Horario horario, String sala, long codigo) {;
		this.alunos = new ArrayList<Aluno>();
		this.disciplina = disciplina;
		this.professor = professor;
		this.horario = horario;
		this.sala = sala;
		this.codigo = codigo;
	}
	
	public String getSala() {
		return this.sala;
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
	
	public boolean isMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	@Override
	public String toString() {
		String resultado = String.format(
				"Turma %s - %s\tProfessor: %s\tHorario: %s\tSala: %s",
				(int) this.codigo,
				this.disciplina.getNome(),
				this.professor.getNome(),
				this.horario,
				this.sala
				);
		return resultado;
	}
}
