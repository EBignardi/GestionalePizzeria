package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ClienteAsporto extends Cliente {
	private String nomeCliente;
	private int orario;
	// private Date data;
	
	public ClienteAsporto(StringProperty[] nomiPizze, IntegerProperty numTavolo, String nomeCliente, int orario) {
		//numTavolo=0 perché non mangia in un tavolo
		super(nomiPizze, numTavolo);
		this.nomeCliente = nomeCliente;
		this.orario = orario;
	}

	public String getNome() {
		return nomeCliente;
	}
	
	public void setNome(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public int getOrario() {
		return orario;
	}
	
	public void setOrario(int orario) {
		this.orario = orario;
	}
	
}
