package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Ordine {
	protected java.sql.Time orario;
	protected java.sql.Date data;
	private FloatProperty prezzoTotale;
	protected StringProperty nomeCliente;
	
	
	public Ordine() {
		java.util.Date today = new java.util.Date();
		long millis=System.currentTimeMillis();
		this.orario = new java.sql.Time(today.getTime());
		this.data = new java.sql.Date(millis);
		this.prezzoTotale = new SimpleFloatProperty();
		this.nomeCliente = new SimpleStringProperty();
	}
	

	public Ordine(java.sql.Time orario, java.sql.Date data,Float prezzoTotale,StringProperty nomeCliente) {
		this.setOrario(orario);
		this.setDate(data);
		this.setPrezzoTotale(prezzoTotale);
		this.setNomeCliente(nomeCliente);
	}
	
	// metodi orario ordine
	public java.sql.Time getOrario() {
		return orario;
	}

	public void setOrario(java.sql.Time Time) {
		this.orario = Time;
	}
	
	public StringProperty getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(StringProperty nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	// metodi data ordine
	public java.sql.Date getData() {
		return data;		
	}

	public void setDate(java.sql.Date date) {
			this.data = date;
	}
	
	
	// metodi prezzo totale ordine
	public FloatProperty getPrezzoProperty() {
			return prezzoTotale;
	}

	public void setPrezzoTotale(float prezzo) {
			this.prezzoTotale.set(prezzo);
	}
		
	public float getPrezzoTotale() {
			return this.prezzoTotale.get();
	}

	
}
