package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

//Classe pricipale
public class Cliente {
	private StringProperty[] nomiPizze;
	private IntegerProperty numTavolo;
	
	public Cliente(StringProperty[] pizza, IntegerProperty numTavolo) {
		this.setNomiPizze(pizza);
		this.setNumTavolo(numTavolo);
	}

	public StringProperty[] getNomiPizzeProperty() {
		return nomiPizze;
	}

	public void setNomiPizze(StringProperty[] nomiPizze) {
		this.nomiPizze = nomiPizze;
	}

	public IntegerProperty getNumTavoloProperty() {
		return numTavolo;
	}

	public void setNumTavolo(IntegerProperty numTavolo) {
		this.numTavolo = numTavolo;
	}


}
