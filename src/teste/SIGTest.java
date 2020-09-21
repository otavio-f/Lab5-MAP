package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entidade.Aluno;
import entidade.Disciplina;
import entidade.Horario;
import entidade.Horario.Dia;
import entidade.Professor;
import facade.SIGFacade;
import sistemas.Entrevista;
import sistemas.Reuniao;

public class SIGTest {

	private SIGFacade sig;
	
	@Before
	public void setUp() throws Exception {
		sig = new SIGFacade();
	}

	@Test
	public void testeAluno() {
		Aluno al1 = new Aluno("Aluno 1", 2000);
		sig.adicionarAluno("Aluno 1", 2000);
		assertEquals(sig.encontrarAluno(2000), al1);
	}
	
	@Test
	public void testeProfessor() {
		Professor pr1 = new Professor("Professor 1", 2001);
		sig.adicionarProfessor("Professor 1", 2001);
		assertEquals(sig.encontrarProfessor(2001), pr1);
	}
	
	@Test
	public void testeDisciplina() {
		Disciplina d1 = new Disciplina("Disciplina 1", 777);
		sig.adicionarDisciplina("Disciplina 1", 777);
		assertEquals(sig.encontrarDisciplina(777).toString(), d1.toString());
	}
	
	@Test
	public void testeReuniao() {
		sig.adicionarReuniao("Assunto 1", "01/01/2000", "00:00");
		sig.adicionarReuniao("Assunto 1", "01/01/2001", "01:01");
		assertEquals(
				sig.reunioesAgendadas(),
				"Marcadas:\n" + 
				"Reunião marcada dia 01/01/2000 às 00:00 sobre o assunto \"Assunto 1\"\n" + 
				"Reunião marcada dia 01/01/2001 às 01:01 sobre o assunto \"Assunto 1\""
				);
	}
	
	@Test
	public void testeEntrevista() {
		sig.adicionarEntrevista("Pessoa 1", "01/01/2000", "00:00");
		assertEquals(
				sig.entrevistas(),
				"Marcadas:\nEntrevista marcada dia 01/01/2000 às 00:00 com Pessoa 1"
				);
	}
	
	@Test
	public void testeAlocacaoPorDisciplina() {
		sig.adicionarProfessor("Prof 1", 1);
		sig.adicionarDisciplina("Disciplina 1", 1234);
		sig.adicionarDisciplina("Disciplina 2", 4321);
		sig.adicionarTurma(
				sig.encontrarDisciplina(1234),
				sig.encontrarProfessor(1),
				new Horario(Dia.DOMINGO, "08:30"),
				"Sala 7",
				10);
		sig.adicionarTurma(
				sig.encontrarDisciplina(4321),
				sig.encontrarProfessor(1),
				new Horario(Dia.QUINTA, "12:00"),
				"Sala 3",
				11);
		assertEquals(
				sig.alocacaoPorDisciplina(sig.encontrarProfessor(1)),
				"Professor: Prof 1\n" + 
				"Turmas:\n" + 
				"	Disciplina 1, domingo - 08:30\n" + 
				"	Disciplina 2, quinta - 12:00"
				);
	}
	
	@Test
	public void testeAlocacaoSalas() {
		sig.adicionarProfessor("Prof 1", 1);
		sig.adicionarDisciplina("Disciplina 1", 1234);
		sig.adicionarDisciplina("Disciplina 2", 4321);
		sig.adicionarTurma(
				sig.encontrarDisciplina(1234),
				sig.encontrarProfessor(1),
				new Horario(Dia.DOMINGO, "08:30"),
				"Sala 7",
				10);
		sig.adicionarTurma(
				sig.encontrarDisciplina(4321),
				sig.encontrarProfessor(1),
				new Horario(Dia.QUINTA, "12:00"),
				"Sala 3",
				11);
		assertEquals(
				sig.alocacaoDeSalas(), 
				"\nSala Sala 7: Disciplina 1 (10)\n" + 
				"Sala Sala 3: Disciplina 2 (11)"
				);
	}
	
	@Test
	public void testeRDM() {
		sig.adicionarAluno("Aluno 1", 1000);
		Aluno al1 = sig.encontrarAluno(1000);
		
		sig.adicionarProfessor("Prof 1", 1);
		sig.adicionarDisciplina("Disciplina 1", 1234);
		sig.adicionarDisciplina("Disciplina 2", 4321);
		sig.adicionarTurma(
				sig.encontrarDisciplina(1234),
				sig.encontrarProfessor(1),
				new Horario(Dia.DOMINGO, "08:30"),
				"Sala 7",
				10);
		sig.encontrarTurma(10).adicionarAluno(al1);
		sig.adicionarTurma(
				sig.encontrarDisciplina(4321),
				sig.encontrarProfessor(1),
				new Horario(Dia.QUINTA, "12:00"),
				"Sala 3",
				11);
		sig.encontrarTurma(11).adicionarAluno(al1);
		assertEquals(
				sig.rdm(sig.encontrarAluno(1000)),
				"Aluno: Aluno 1	Matricula: 1000\n" + 
				"Turmas matriculadas:\n" + 
				"Turma 10 - Disciplina 1	Professor: Prof 1	Horario: domingo - 08:30	Sala: Sala 7\n" + 
				"Turma 11 - Disciplina 2	Professor: Prof 1	Horario: quinta - 12:00	Sala: Sala 3"
				);
	}
	
	@Test
	public void testeConsultaFolhaDePagamento() {
		sig.novaFolhaDePagamento("Setembro");
		sig.adicionarFuncionarioAFolha(0, "Prof 1", 10000);
		sig.adicionarFuncionarioAFolha(0, "Func 2", 2000);
		sig.adicionarFuncionarioAFolha(0, "Func 3", 2000);
		assertEquals(
				sig.consultarFolhaDePagamento(0),
				"Folha de Pagamento do mês de Setembro\n" + 
				"Funcionário: Prof 1 - Salário: 10000,00\n" + 
				"Funcionário: Func 2 - Salário: 2000,00\n" + 
				"Funcionário: Func 3 - Salário: 2000,00\n"
				);
	}
	
	@Test
	public void testeConsultaBalanco() {
		sig.novoBalanco("Agosto");
		sig.adicionarContaBalanco(0, "Material de escritório", 1200.00);
		sig.adicionarContaBalanco(0, "Internet", 1500.00);
		sig.adicionarContaBalanco(0, "Energia", 950.00);
		sig.adicionarContaBalanco(0, "Eventos", 3.400);
		assertEquals(
				sig.consultarBalanco(0),
				"Contas do mês de Agosto\n" + 
				"Conta: Material de escritório - Valor: 1200,00\n" + 
				"Conta: Internet - Valor: 1500,00\n" + 
				"Conta: Energia - Valor: 950,00\n" + 
				"Conta: Eventos - Valor: 3,40\n"
				);
	}
	
	@Test
	public void testeEstoque() {
		sig.inserirNoEstoque("Material 1", 350);
		sig.inserirNoEstoque("Material 2", 2000);
		assertEquals(
				sig.consultarEstoque(),
				"Estoque dos produtos:\n" + 
				"Produto: Material 1 - Quantidade: 350\n" + 
				"Produto: Material 2 - Quantidade: 2000\n"
				);
	}
}
