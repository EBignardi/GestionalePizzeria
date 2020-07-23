package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;


public class Ordine {
	protected java.sql.Time orario;
	protected java.sql.Date data;
	private FloatProperty prezzoTotale;
	
	
	public Ordine() {
		java.util.Date today = new java.util.Date();
		long millis=System.currentTimeMillis();
		this.orario = new java.sql.Time(today.getTime());
		this.data = new java.sql.Date(millis);
		this.prezzoTotale = new SimpleFloatProperty();
	}
	

	public Ordine(java.sql.Time orario, java.sql.Date data) {
		this.setOrario(orario);
		this.setDate(data);
		
	}
	
	// metodi orario ordine
	public java.sql.Time getOrario() {
		return orario;
	}

	public void setOrario(java.sql.Time Time) {
		this.orario = Time;
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

	public void setPrezzo(float prezzo) {
			this.prezzoTotale.set(prezzo);
	}
		
	public float getPrezzo() {
			return this.prezzoTotale.get();
	}

	
}
