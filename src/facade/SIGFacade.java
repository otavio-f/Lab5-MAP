package facade;

import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Disciplina;
import entidade.Professor;
import entidade.Turma;

public class SIGFacade {
	
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Disciplina> disciplinas;
	private List<Turma> turmas;
	
	public SIGFacade() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.turmas = new ArrayList<Turma>();
	}
	
	

}
