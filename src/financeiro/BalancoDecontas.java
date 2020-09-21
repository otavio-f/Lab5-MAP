package financeiro;

import java.util.ArrayList;
import java.util.List;

public class BalancoDecontas {
	private String mes;
	private List<Conta> contas;
	
	public BalancoDecontas (String mes) {
		setMes(mes);
		contas = new ArrayList<>();
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void adicionarConta(String conta, double valor) {
		contas.add(new Conta(conta, valor));
	}
	
	public List<Conta> getContas(){
		return contas;
	}
	
	public String consultarBalanco() {
		StringBuilder string = new StringBuilder("Contas do m�s de "+getMes()+"\n");
		if(contas.isEmpty()) {
			string.append("Nenhuma conta registrada.\n");
		}else {
			for(Conta conta : contas) {
				string.append(conta);
			}
		}
		
		return string.toString();
	}
}
