package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ordine {
	private StringProperty orario;
	private StringProperty data;
	private FloatProperty prezzoTotale;
	private StringProperty nomeCliente;
	private StringProperty indirizzo;

	
	public Ordine() {
		this.orario = new SimpleStringProperty();
		this.data =new SimpleStringProperty();
		this.prezzoTotale = new SimpleFloatProperty();
		this.nomeCliente = new SimpleStringProperty();
		this.indirizzo=new SimpleStringProperty();
	}
	

	public Ordine(String orario, String data,Float prezzoTotale,StringProperty nomeCliente,StringProperty indirizzo) {
		this.setOrario(orario);
		this.setDate(data);
		this.setPrezzoTotale(prezzoTotale);
		this.setNomeCliente(nomeCliente);
		this.setIndirizzo(indirizzo);
		
	}
	
	// metodi orario ordine
	public StringProperty getOrarioProperty() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario.set(orario);
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
	public StringProperty getDataProperty() {
		return data;		
	}

	public void setDate(String date) {
			this.data.set(date);;
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
