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
		sig.adicionarProfessor("Júlia", 7777);
		sig.adicionarProfessor("Mário", 1656);
		
		//ADICIONANDO DISCIPLINAS
		sig.adicionarDisciplina("Contabilidade Avançada", 12);
		sig.adicionarDisciplina("Computação Básica", 313);
		
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
		
		
		//ADICIONANDO INFORMAÇÕES ADMINISTRATIVAS
		sig.adicionarReuniao("Orientação acerca de novos equipamentos", "23/11/2018", "12:00");
		sig.adicionarReuniao("Discussão dos orientadores", "03/01/2021", "13:00");
		
		sig.adicionarEntrevista("Dra. Josefa", "30/03/2021", "13:00");
		sig.adicionarEntrevista("Sindicato", "30/12/2020", "23:00");
		
		//ADICIONANDO INFORMAÇÕES DO ALMOXARIFADO
		sig.inserirNoEstoque("Caneta bic", 350);
		sig.inserirNoEstoque("Folha A4 - RESMA", 2000);
		sig.inserirNoEstoque("Lápis - Quadro negro", 200);
		sig.inserirNoEstoque("Café", 90);
		
		//ADICIONANDO INFORMAÇOES FINANCEIRAS
		sig.novaFolhaDePagamento("Setembro");
		sig.adicionarFuncionarioAFolha(0, "Sabrina", 10000);
		sig.adicionarFuncionarioAFolha(0, "Paulo", 12000);
		sig.adicionarFuncionarioAFolha(0, "João", 8000);

		sig.novoBalanco("Agosto");
		sig.adicionarContaBalanco(0, "Material de escritório", 1200.00);
		sig.adicionarContaBalanco(0, "Internet", 1500.00);
		sig.adicionarContaBalanco(0, "Energia", 950.00);
		sig.adicionarContaBalanco(0, "Eventos", 3.400);
		
		System.out.println("* Informações administrativas");
		System.out.println("REUNIÕES");
		System.out.println(sig.reunioesAgendadas());
		System.out.println("ENTREVISTAS");
		System.out.println(sig.entrevistas());
		
		System.out.println("\n* Informações financeiras");
		System.out.println(sig.consultarFolhaDePagamento(0));
		
		System.out.println("\n* Balanços");
		System.out.println(sig.consultarBalanco(0));
		
		System.out.println("\n* Informações relacionadas aos professores");
		System.out.println("ALOCAÇÃO DE DISCIPLINAS");
		System.out.println(sig.alocacaoPorDisciplina(sig.encontrarProfessor(7777)));
		
		System.out.println("\n* Informações relacionadas aos alunos");
		System.out.println("REGISTRO DE MATRÍCULA:");
		System.out.println(sig.rdm(sig.encontrarAluno(1234321)));
		
		System.out.println("\n* Informações relacionadas ao almoxarifado");
		System.out.println(sig.consultarEstoque());
	

	}

}