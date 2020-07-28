package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Ordine {
	private java.sql.Time orario;
	private java.sql.Date data;
	private FloatProperty prezzoTotale;
	private StringProperty nomeCliente;
	private StringProperty indirizzo;

	
	public Ordine() {
		java.util.Date today = new java.util.Date();
		long millis=System.currentTimeMillis();
		this.orario = new java.sql.Time(today.getTime());
		this.data = new java.sql.Date(millis);
		this.prezzoTotale = new SimpleFloatProperty();
		this.nomeCliente = new SimpleStringProperty();
		this.indirizzo=new SimpleStringProperty();
	}
	

	public Ordine(java.sql.Time orario, java.sql.Date data,Float prezzoTotale,StringProperty nomeCliente,StringProperty indirizzo) {
		this.setOrario(orario);
		this.setDate(data);
		this.setPrezzoTotale(prezzoTotale);
		this.setNomeCliente(nomeCliente);
		this.setIndirizzo(indirizzo);
		
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
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente.set(nomeCliente);
	}
	
	// metodi data ordine
	public java.util.Date getData() {
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
	
	public void setIndirizzo(StringProperty indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public StringProperty getIndirizzoProperty() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo.set(indirizzo);
	}
}
