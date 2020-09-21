package main;

import entidade.Horario;
import entidade.Horario.Dia;
import facade.SIGFacade;

public class Main {

	public static void main(String[] args) {
		SIGFacade sig = new SIGFacade();
		
		sig.adicionarAluno("Otavio", 1234321);
		sig.adicionarAluno("Rafael", 3339000);
		
		sig.adicionarProfessor("Júlia", 7777);
		sig.adicionarProfessor("Mário", 1656);
		
		sig.adicionarDisciplina("Contabilidade Avançada", 12);
		sig.adicionarDisciplina("Computação Básica", 313);
		
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

		sig.adicionarTurma(
				sig.encontrarDisciplina(313),
				sig.encontrarProfessor(7777),
				new Horario(Dia.SEGUNDA, "14:00"),
				133146
				);
		
		sig.encontrarTurma(133145).adicionarAluno(sig.encontrarAluno(1234321));
		sig.encontrarTurma(133146).adicionarAluno(sig.encontrarAluno(3339000));
		
		sig.adicionarReuniao("Orientação acerca de novos equipamentos", "23/11/2018", "12:00");
		sig.adicionarReuniao("Discussão dos orientadores", "03/01/2021", "13:00");
		
		sig.adicionarEntrevista("Dra. Josefa", "30/03/2021", "13:00");
		
		System.out.println("* Informações administrativas");
		System.out.println("REUNIÕES");
		System.out.println(sig.reunioesAgendadas());
		System.out.println("ENTREVISTAS");
		System.out.println(sig.entrevistas());
		
		System.out.println("\n* Informações financeiras");
		
		System.out.println("\n* Informações relacionadas aos professores");
		System.out.println("ALOCAÇÃO DE DISCIPLINAS");
		System.out.println(sig.alocacaoPorDisciplina(sig.encontrarProfessor(7777)));
		
		System.out.println("\n* Informações relacionadas aos alunos");
		System.out.println("REGISTRO DE MATRÍCULA:");
		System.out.println(sig.rdm(sig.encontrarAluno(1234321)));
		
		System.out.println("\n* Informações relacionadas ao almoxarifado");
		
		System.out.println("\n* Informações de infra-estrutura");

	}

}