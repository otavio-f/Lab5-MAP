package facade;

import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Disciplina;
import entidade.Horario;
import entidade.Professor;
import entidade.Turma;
import sistemas.Entrevista;
import sistemas.Reuniao;

public class SIGFacade {
	
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Disciplina> disciplinas;
	private List<Turma> turmas;
	
	private List<Reuniao> reunioes;
	private List<Entrevista> entrevistas;
	
	public SIGFacade() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.turmas = new ArrayList<Turma>();
		
		this.reunioes = new ArrayList<Reuniao>();
		this.entrevistas = new ArrayList<Entrevista>();
	}
	
	public void adicionarTurma(Disciplina disc, Professor prof, Horario horario, String sala, long codigo) {
		this.turmas.add(new Turma(disc, prof, horario, sala, codigo));
	}
	
	public Turma encontrarTurma(long cod) {
		for(Turma t:turmas)
			if(t.getCodigo()==cod)
				return t;
		return null;
	}
	
	public void adicionarDisciplina(String nome, long cod) {
		this.disciplinas.add(new Disciplina(nome, cod));
	}
	
	public Disciplina encontrarDisciplina(long cod) {
		for(Disciplina d:disciplinas)
			if(d.getCodigo()==cod)
				return d;
		return null;
	}

	public void adicionarProfessor(String nome, long matricula) {
		this.professores.add(new Professor(nome, matricula));
	}
	
	public Professor encontrarProfessor(long matricula) {
		for(Professor p:professores)
			if(p.getMatricula()==matricula)
				return p;
		return null;
	}

	public void adicionarAluno(String nome, long matricula) {
		this.alunos.add(new Aluno(nome, matricula));
	}
	
	public Aluno encontrarAluno(long matricula) {
		for(Aluno a:alunos)
			if(a.getMatricula()==matricula)
				return a;
		return null;
	}
	
	public void adicionarReuniao(String assunto, String data, String hora) {
		this.reunioes.add(new Reuniao(assunto, data, hora));	
	}
	
	public void adicionarEntrevista(String nome, String data, String hora) {
		this.entrevistas.add(new Entrevista(nome, data, hora));	
	}
	
	public String reunioesAgendadas() {
		String resultado = "Marcadas:";
		for(Reuniao r: reunioes)
			resultado += "\n"+r.toString();
		return resultado;
	}
	
	public String entrevistas() {
		String resultado = "Marcadas:";
		for(Entrevista e: entrevistas)
			resultado += "\n"+e.toString();
		return resultado;
	}
	
	public String balancoDeContas() {
		return null;
	}
	
	public String folhaDePagamento() {
		return null;
	}
	
	public String alocacaoPorDisciplina(Professor prof) {
		String resultado = String.format("Professor: %s\nTurmas:", prof.getNome());
		for(Turma t: turmas)
			if(t.getProfessor().equals(prof))
				resultado += String.format("\n\t%s, %s", t.getDisciplina().getNome(), t.getHorario());
		return resultado;
	}
	
	public String tempoDeCasa(Professor prof) {
		return null;
	}
	
	public String historico(Aluno aluno) {
		return null;
	}
	
	public String rdm(Aluno aluno) {
		String resultado = aluno.toString()+"\nTurmas matriculadas:";
		for(Turma t: turmas)
			if(t.isMatriculado(aluno))
				resultado += "\n" + t.toString();
		return resultado;
	}
	
	public String estoque() {
		return null;
	}
	
	public String alocacaoDeSalas() {
		String resultado = "";
		for(Turma t: turmas)
			resultado += String.format(
					"\nSala %s: %s (%s)",
					t.getSala(),
					t.getDisciplina().getNome(),
					(int) t.getCodigo()
					);
		return resultado;
	}

}
