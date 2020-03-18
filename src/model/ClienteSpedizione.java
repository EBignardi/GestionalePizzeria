package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ClienteSpedizione extends ClienteAsporto {
	private StringProperty indirizzo;
	private IntegerProperty numeroCivico;
	private IntegerProperty numeroTelefono;
	
	public ClienteSpedizione(Pizza elencoPizze, IntegerProperty numTavolo, StringProperty nomeCliente, IntegerProperty orario,
			StringProperty indirizzo, IntegerProperty numeroCivico, IntegerProperty numeroTelefono) {
		//numTavolo=0 perché non mangia in un tavolo
		super(elencoPizze, numTavolo, nomeCliente, orario);
		this.setIndirizzo(indirizzo);
		this.setNumeroCivico(numeroCivico);
		this.setNumeroTelefono(numeroTelefono);
	}

	public StringProperty getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(StringProperty indirizzo) {
		this.indirizzo = indirizzo;
	}

	public IntegerProperty getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(IntegerProperty numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public IntegerProperty getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(IntegerProperty numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	
}
