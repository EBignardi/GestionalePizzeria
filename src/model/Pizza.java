package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pizza {
	private StringProperty nomePizza;
	private FloatProperty prezzoPizza;

	
	public Pizza() {
		this.nomePizza = new SimpleStringProperty();
		this.prezzoPizza = new SimpleFloatProperty();
	}
	
	public Pizza(StringProperty nomePizza, FloatProperty prezzoPizza) {
		this.nomePizza = nomePizza;
		this.prezzoPizza = prezzoPizza;
	}

	// metodi sul nome pizza
	public StringProperty getNomePizzaProperty() {
		return nomePizza;
	}
	
	public void setNomePizza(String nomePizza) {
		this.nomePizza.set(nomePizza);
	}
	
	public String getNome() {
		return this.nomePizza.get();
	}

	// metodi sul prezzo pizza
	public FloatProperty getPrezzoProperty() {
		return prezzoPizza;
	}

	public void setPrezzo(float prezzo) {
		this.prezzoPizza.set(prezzo);
	}
	
	public float getPrezzo() {
		return this.prezzoPizza.get();
	}
}
