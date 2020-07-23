package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

//Classe pricipale per tutti i Clienti
public class Cliente {
	protected IntegerProperty numTavolo;
	
	//allocazione classe cliente senza input
	public Cliente() {
		this.numTavolo = new SimpleIntegerProperty();
	}
	
	
	public Cliente(IntegerProperty numTavolo) {
		this.numTavolo = numTavolo;
	}
	
	// metodi Numero Tavolo
	public IntegerProperty getNumTavoloProperty() {
		return this.numTavolo;
	}

	public void setNumTavolo(Integer numTavolo) {
		this.numTavolo.set(numTavolo);
	}
	
	public Integer getNumTavolo() {
		return this.numTavolo.get();
	}

	
}
