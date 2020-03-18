package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pizza {
	/**
	 * nomePizza corrisponde al nome completo della pizza stessa 
	 * oppure all'insieme degli ingredienti
	 */
	private StringProperty nomePizza;
	private FloatProperty prezzo;
	private StringProperty ingredienti;
	
	
	public Pizza() {
		this.nomePizza = new SimpleStringProperty();
		this.prezzo = new SimpleFloatProperty();
		this.ingredienti = new SimpleStringProperty();
	}
	
	public StringProperty getNomePizzaProperty() {
		return nomePizza;
	}
	
	public void setNomePizza(String nomePizza) {
		this.nomePizza.set(nomePizza);
	}
	
	public String getNome() {
		return this.nomePizza.get();
	}

	public FloatProperty getPrezzoProperty() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo.set(prezzo);
	}
	
	public float getPrezzo() {
		return this.prezzo.get();
	}

	public StringProperty getIngredientiProperty() {
		return ingredienti;
	}
	
	public void setIngredienti(String ingredienti) {
		this.ingredienti.set(ingredienti);
	}
	
	public String getIngredienti() {
		return this.ingredienti.get();
	}
	
}
