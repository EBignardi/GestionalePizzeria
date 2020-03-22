package model;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteAsporto extends Cliente {
	protected StringProperty nomeCliente;
	protected LocalTime orario;
	protected LocalDate data;
	
	//allocazione classe cliente Asporto senza input
	public ClienteAsporto() {
		this.setElencoPizze(new ArrayList<Pizza>());
		this.numTavolo.set(0);
		this.nomeCliente = new SimpleStringProperty();
		this.orario = new LocalTime();
		this.data = new LocalDate();
	}
	
	public ClienteAsporto( ArrayList<Pizza> elencoPizze, IntegerProperty numTavolo, StringProperty nomeCliente,
			LocalTime orario, LocalDate data) {
		//settare numTavolo=0 perché non mangia in un tavolo
		super(elencoPizze, numTavolo);
		this.setNomeCliente(nomeCliente);
		this.setOrario(orario);
		this.setData(data);
	}

	// metodi Nome Cliente Asporto
	public StringProperty getNomeClienteProperty() {
		return nomeCliente;
	}

	public void setNomeCliente(StringProperty nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente.get();
	}
	
	// metodi Orario Cliente Asporto
	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	
	// metodi Data Cliente Asporto
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
