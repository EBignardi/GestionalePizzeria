package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bibita {
	private StringProperty nomeBibita;
	private FloatProperty prezzoBibita;

	public Bibita() {
		this.nomeBibita = new SimpleStringProperty();
		this.prezzoBibita = new SimpleFloatProperty();
	}
	
	public Bibita(StringProperty nomeBibita, FloatProperty prezzoBibita) {
		this.nomeBibita = nomeBibita;
		this.prezzoBibita = prezzoBibita;
	}

	// metodi sul nome bibita
	public StringProperty getNomeBibitaProperty() {
		return nomeBibita;
	}
	
	public void setNomeBibita(String nomeBibita) {
		this.nomeBibita.set(nomeBibita);
	}
	
	public String getNome() {
		return this.nomeBibita.get();
	}

	// metodi sul prezzo bibita
	public FloatProperty getPrezzoBibitaProperty() {
		return prezzoBibita;
	}

	public void setPrezzo(float prezzo) {
		this.prezzoBibita.set(prezzo);
	}
	
	public float getPrezzo() {
	return this.prezzoBibita.get();
	}
	
}
