package main;

import entidade.Horario;
import entidade.Horario.Dia;
import facade.SIGFacade;

public class Main {

	public static void main(String[] args) {
		SIGFacade sig = new SIGFacade();
		
		sig.adicionarAluno("Otavio", 1234321);
		sig.adicionarAluno("Rafael", 3339000);
		
		sig.adicionarProfessor("J�lia", 7777);
		sig.adicionarProfessor("M�rio", 1656);
		
		sig.adicionarDisciplina("Contabilidade Avan�ada", 12);
		sig.adicionarDisciplina("Medita��o", 313);
		
		sig.adicionarTurma(
				sig.encontrarDisciplina(12),
				sig.encontrarProfessor(7777),
				new Horario(Dia.QUARTA, "07:30"),
				133145
				);
		
		sig.adicionarTurma(
				sig.encontrarDisciplina(12),
				sig.encontrarProfessor(7777),
				new Horario(Dia.SEXTA, "19:30"),
				133146
				);
		
		sig.encontrarTurma(133145).adicionarAluno(sig.encontrarAluno(1234321));
		sig.encontrarTurma(133146).adicionarAluno(sig.encontrarAluno(3339000));
		
		System.out.println("* Informa��es administrativas");
		
		System.out.println("\n* Informa��es financeiras");
		
		System.out.println("\n* Informa��es relacionadas aos professores");
		System.out.println("ALOCA��O DE DISCIPLINAS");
		System.out.println(sig.alocacaoPorDisciplina(sig.encontrarProfessor(7777)));
		
		System.out.println("\n* Informa��es relacionadas aos alunos");
		System.out.println("REGISTRO DE MATR�CULA:");
		System.out.println(sig.rdm(sig.encontrarAluno(1234321)));
		
		System.out.println("\n* Informa��es relacionadas ao almoxarifado");
		
		System.out.println("\n* Informa��es de infra-estrutura");

	}

}