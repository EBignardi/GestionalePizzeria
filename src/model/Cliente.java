package model;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

//Classe pricipale per tutti i Clienti
public class Cliente {
	protected ArrayList<Pizza> elencoPizze;
	protected IntegerProperty numTavolo;
	
	//allocazione classe cliente senza input
	public Cliente() {
		this.setElencoPizze(new ArrayList<Pizza>());
		this.numTavolo = new SimpleIntegerProperty();
	}
	
	
	public Cliente(ArrayList<Pizza> elencoPizze, IntegerProperty numTavolo) {
		this.setElencoPizze(elencoPizze);
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

	// metodi Elenco Pizze
	public ArrayList<Pizza> getElencoPizze() {
		return elencoPizze;
	}

	public void setElencoPizze(ArrayList<Pizza> elencoPizze) {
		this.elencoPizze = elencoPizze;
	}
}
