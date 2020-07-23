package model;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;


public class Ordine {
	protected LocalTime orario;
	protected LocalDate data;
	private FloatProperty prezzoTotale;
	
	
	public Ordine() {
		this.orario = LocalTime.now()  ;
		this.data = LocalDate.now();
		this.prezzoTotale = new SimpleFloatProperty();
	}
	

	public Ordine(LocalTime orario, LocalDate data) {
		this.setOrario(orario);
		this.setDate(data);
		
	}
	
	// metodi orario ordine
	public LocalDate getOrario() {
		return LocalDate.now();
	}

	public void setOrario(LocalTime localTime) {
		this.orario = localTime;
	}
	
	
	// metodi data ordine
	public LocalDate getData() {
		return data;		
	}

	public void setDate(LocalDate date) {
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
