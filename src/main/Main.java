package main;

import entidade.Horario;
import entidade.Horario.Dia;
import facade.SIGFacade;

public class Main {

	public static void main(String[] args) {
		SIGFacade sig = new SIGFacade();
		
		//ADICIONANDO ALUNOS
		sig.adicionarAluno("Otavio", 1234321);
		sig.adicionarAluno("Rafael", 3339000);
		
		//ADICIONANDO PROFESSORES
		sig.adicionarProfessor("J�lia", 7777);
		sig.adicionarProfessor("M�rio", 1656);
		
		//ADICIONANDO DISCIPLINAS
		sig.adicionarDisciplina("Contabilidade Avan�ada", 12);
		sig.adicionarDisciplina("Computa��o B�sica", 313);
		
		//ADICIONANDO TURMAS
		sig.adicionarTurma(
				sig.encontrarDisciplina(12),
				sig.encontrarProfessor(7777),
				new Horario(Dia.QUARTA, "07:30"),
				"B133",
				133145
				);
		
		sig.adicionarTurma(
				sig.encontrarDisciplina(12),
				sig.encontrarProfessor(7777),
				new Horario(Dia.SEXTA, "19:30"),
				"A43",
				133146
				);

		sig.adicionarTurma(
				sig.encontrarDisciplina(313),
				sig.encontrarProfessor(7777),
				new Horario(Dia.SEGUNDA, "14:00"),
				"Lab 2",
				133146
				);
		
		sig.encontrarTurma(133145).adicionarAluno(sig.encontrarAluno(1234321));
		sig.encontrarTurma(133146).adicionarAluno(sig.encontrarAluno(3339000));
		
		
		//ADICIONANDO INFORMA��ES ADMINISTRATIVAS
		sig.adicionarReuniao("Orienta��o acerca de novos equipamentos", "23/11/2018", "12:00");
		sig.adicionarReuniao("Discuss�o dos orientadores", "03/01/2021", "13:00");
		
		sig.adicionarEntrevista("Dra. Josefa", "30/03/2021", "13:00");
		sig.adicionarEntrevista("Sindicato", "30/12/2020", "23:00");
		
		//ADICIONANDO INFORMA��ES DO ALMOXARIFADO
		sig.inserirNoEstoque("Caneta bic", 350);
		sig.inserirNoEstoque("Folha A4 - RESMA", 2000);
		sig.inserirNoEstoque("L�pis - Quadro negro", 200);
		sig.inserirNoEstoque("Caf�", 90);
		
		//ADICIONANDO INFORMA�OES FINANCEIRAS
		sig.novaFolhaDePagamento("Setembro");
		sig.adicionarFuncionarioAFolha(0, "Sabrina", 10000);
		sig.adicionarFuncionarioAFolha(0, "Paulo", 12000);
		sig.adicionarFuncionarioAFolha(0, "Jo�o", 8000);

		sig.novoBalanco("Agosto");
		sig.adicionarContaBalanco(0, "Material de escrit�rio", 1200.00);
		sig.adicionarContaBalanco(0, "Internet", 1500.00);
		sig.adicionarContaBalanco(0, "Energia", 950.00);
		sig.adicionarContaBalanco(0, "Eventos", 3.400);
		
		System.out.println("* Informa��es administrativas");
		System.out.println("REUNI�ES");
		System.out.println(sig.reunioesAgendadas());
		System.out.println("ENTREVISTAS");
		System.out.println(sig.entrevistas());
		
		System.out.println("\n* Informa��es financeiras");
		System.out.println(sig.consultarFolhaDePagamento(0));
		
		System.out.println("\n* Balan�os");
		System.out.println(sig.consultarBalanco(0));
		
		System.out.println("\n* Informa��es relacionadas aos professores");
		System.out.println("ALOCA��O DE DISCIPLINAS");
		System.out.println(sig.alocacaoPorDisciplina(sig.encontrarProfessor(7777)));
		
		System.out.println("\n* Informa��es relacionadas aos alunos");
		System.out.println("REGISTRO DE MATR�CULA:");
		System.out.println(sig.rdm(sig.encontrarAluno(1234321)));
		
		System.out.println("\n* Informa��es relacionadas ao almoxarifado");
		System.out.println(sig.consultarEstoque());
	

	}

}