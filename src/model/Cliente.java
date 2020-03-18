package model;

import javafx.beans.property.IntegerProperty;

//Classe pricipale
public class Cliente {
	private Pizza elencoPizze;
	private IntegerProperty numTavolo;
	
	public Cliente(Pizza elencoPizze, IntegerProperty numTavolo) {
		this.setElencoPizze(elencoPizze);
		this.setNumTavolo(numTavolo);
	}
	
	public IntegerProperty getNumTavoloProperty() {
		return numTavolo;
	}

	public void setNumTavolo(IntegerProperty numTavolo) {
		this.numTavolo = numTavolo;
	}
	
	public Integer getNumTavolo() {
		return this.numTavolo.get();
	}

	public Pizza getElencoPizze() {
		return elencoPizze;
	}

	public void setElencoPizze(Pizza elencoPizze) {
		this.elencoPizze = elencoPizze;
	}


}
