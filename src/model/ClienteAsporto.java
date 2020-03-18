package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ClienteAsporto extends Cliente {
	private StringProperty nomeCliente;
	private IntegerProperty orario;
	// private Date data;
	
	public ClienteAsporto(Pizza elencoPizze, IntegerProperty numTavolo, StringProperty nomeCliente, IntegerProperty orario) {
		//settare numTavolo=0 perché non mangia in un tavolo
		super(elencoPizze, numTavolo);
		this.setNomeCliente(nomeCliente);
		this.setOrario(orario);
	}

	public StringProperty getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(StringProperty nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public IntegerProperty getOrario() {
		return orario;
	}

	public void setOrario(IntegerProperty orario) {
		this.orario = orario;
	}


}
