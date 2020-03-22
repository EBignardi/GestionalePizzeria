package model;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteSpedizione extends ClienteAsporto {
	protected StringProperty indirizzo;
	protected IntegerProperty numeroCivico;
	protected IntegerProperty numeroTelefono;
	
	//allocazione classe cliente Spedizione senza input
	public ClienteSpedizione() {
		this.setElencoPizze(new ArrayList<Pizza>());
		this.numTavolo.set(0);
		this.nomeCliente = new SimpleStringProperty();
		this.orario = new LocalTime();
		this.data = new LocalDate();
		this.indirizzo = new SimpleStringProperty();
		this.numeroCivico = new SimpleIntegerProperty();
		this.numeroTelefono = new SimpleIntegerProperty();
	}

	public ClienteSpedizione(ArrayList<Pizza> elencoPizze, IntegerProperty numTavolo, StringProperty nomeCliente,
			LocalTime orario, LocalDate data) {
		super(elencoPizze, numTavolo, nomeCliente, orario, data);
		this.setIndirizzo(indirizzo);
		this.setNumeroCivico(numeroCivico);
		this.setNumeroTelefono(numeroTelefono);
	}


	// metodi Indirizzo Cliente Spedizione
	public StringProperty getIndirizzoProperty() {
		return indirizzo;
	}

	public void setIndirizzo(StringProperty indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getIndirizzo() {
		return this.nomeCliente.get();
	}

	// metodi Numero Civico Cliente Spedizione
	public IntegerProperty getNumeroCivicoProperty() {
		return numeroCivico;
	}

	public void setNumeroCivico(IntegerProperty numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public Integer getNumeroCivico() {
		return this.numeroCivico.get();
	}
	
	// metodi Numero Telefono Cliente Spedizione
	public IntegerProperty getNumeroTelefonoProperty() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(IntegerProperty numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Integer getNumeroTelefono() {
		return this.numeroTelefono.get();
	}
	
}
