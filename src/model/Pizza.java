package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pizza {
	private StringProperty nomePizza;
	private FloatProperty prezzo;
	private StringProperty ingredienti;
	private String bibita;

	
	
	public Pizza() {
		this.nomePizza = new SimpleStringProperty();
		this.prezzo = new SimpleFloatProperty();
		this.ingredienti = new SimpleStringProperty();
	}
	
	public Pizza(StringProperty nomePizza, FloatProperty prezzo, StringProperty ingredienti) {
		this.nomePizza = nomePizza;
		this.prezzo = prezzo;
		this.ingredienti = ingredienti;
	}
	
	public Pizza(StringProperty nomePizza, FloatProperty prezzo, StringProperty ingredienti, String bibita2) {
		this.nomePizza = nomePizza;
		this.prezzo = prezzo;
		this.ingredienti = ingredienti;
		this.bibita =bibita2;
	}

	// metodi Nome Pizza
	public StringProperty getNomePizzaProperty() {
		return nomePizza;
	}
	
	public void setNomePizza(String nomePizza) {
		this.nomePizza.set(nomePizza);
	}
	
	public String getNome() {
		return this.nomePizza.get();
	}

	// metodi Prezzo Pizza
	public FloatProperty getPrezzoProperty() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo.set(prezzo);
	}
	
	public float getPrezzo() {
		return this.prezzo.get();
	}

	// metodi Ingredienti Pizza
	public StringProperty getIngredientiProperty() {
		return ingredienti;
	}
	
	public void setIngredienti(String ingredienti) {
		this.ingredienti.set(ingredienti);
	}
	
	public String getIngredienti() {
		return this.ingredienti.get();
	}
	
	public String getBibita() {
		return bibita;
	}
	
	public void setBibita(String bibita) {
		this.bibita = bibita;
	}

	
}
