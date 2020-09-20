package entidade;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Turma {
	private List<Horario> horarios;
	private List<Aluno> alunos;
	private Disciplina disciplina;
	private Professor professor;
	
	public Turma(Disciplina disciplina, Professor professor) {
		this.horarios = new ArrayList<Horario>();
		this.alunos = new ArrayList<Aluno>();
		this.disciplina = disciplina;
		this.professor = professor;
	}
	
	public void adicionarHorario(DayOfWeek dia, String hora) {
		this.horarios.add(new Horario(dia, hora));
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
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
}
