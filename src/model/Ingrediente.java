package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ingrediente {
	private StringProperty nomeIngrediente;
	private FloatProperty sovraprezzo;
	
	public Ingrediente() {
		this.nomeIngrediente = new SimpleStringProperty();
		this.sovraprezzo = new SimpleFloatProperty();
	}

	public StringProperty getNomeIngredienteProperty() {
		return nomeIngrediente;
	}

	public String getNomeIngrediente() {
		return this.nomeIngrediente.get();
	}
	
	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente.set(nomeIngrediente);
	}

	public FloatProperty getCostoProperty() {
		return sovraprezzo;
	}
	
	public float getCosto() {
		return this.sovraprezzo.get();
	}

	public void setCosto(Float costo) {
		this.sovraprezzo.set(costo);
	}
}
