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
	
	public String reunioesAgendadas() {
		return null;
	}
	
	public String entrevistas() {
		return null;
	}
	
	public String balancoDeContas() {
		return null;
	}
	
	public String folhaDePagamento() {
		return null;
	}
	
	public String alocacaoPorDisciplina(Professor prof) {
		String resultado = prof.toString()+"Turmas:\n";
		for(Turma t: turmas)
			if(t.getProfessor().equals(prof))
				resultado += String.format("%s > %s", t.getDisciplina().getNome(), t.getHorario());
		return resultado;
	}
	
	public String tempoDeCasa(Professor prof) {
		return null;
	}
	
	public String historico(Aluno aluno) {
		return null;
	}
	
	public String rdm(Aluno aluno) {
		String resultado = aluno.toString();
		for(Turma t: turmas)
			if(t.isMatriculado(aluno))
				resultado += "\n" + t.toString();
		return resultado;
	}
	
	public String estoque() {
		return null;
	}
	
	public String alocacao() {
		return null;
	}

}
