package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pizza {
	private StringProperty nomePizza;
	private FloatProperty prezzoPizza;
	private StringProperty ingredienti;
	private StringProperty bibita;
	
	public Pizza() {
		this.nomePizza = new SimpleStringProperty();
		this.prezzoPizza = new SimpleFloatProperty();
		this.ingredienti = new SimpleStringProperty();
		this.bibita = new SimpleStringProperty();
	}
	
	public Pizza(StringProperty nomePizza, FloatProperty prezzoPizza,StringProperty ingredienti) {
		this.nomePizza = nomePizza;
		this.prezzoPizza = prezzoPizza;
		this.ingredienti = ingredienti;
	}
	
	public Pizza(StringProperty nomePizza, FloatProperty prezzoPizza,StringProperty ingredienti,StringProperty bibita) {
		this.nomePizza = nomePizza;
		this.prezzoPizza = prezzoPizza;
		this.ingredienti = ingredienti;
		this.bibita=bibita;
	}
	
	public Pizza(String nomePizza, Float prezzoPizza,String ingredienti,String bibita) {
		setNomePizza(nomePizza);
		setPrezzo(prezzoPizza);
		setIngredientiPizza(ingredienti);
		setBibitaPizza(bibita);
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
	
	
	public StringProperty getBibitaProperty() {
		return bibita;
	}
	
	public void setBibitaPizza(String bibita) {
		this.bibita.set(bibita);
	}
	
	public String getBibita() {
		return this.bibita.get();
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

	// metodi su ingredienti pizza
	public StringProperty getIngredientiPizzaProperty() {
		return ingredienti;
	}
	
	public void setIngredientiPizza(String ingredienti) {
		this.ingredienti.set(ingredienti);
	}
	
	public String getIngredienti() {
		return this.ingredienti.get();
	}
	
	
	//metodo per rimuovere ingrediente alla pizza
	public String removeIngrediente(String word) 
    { 
		String a = this.getIngredienti();
		System.out.println("The word to remove is : "+word);
      
        String target=String.copyValueOf(word.toCharArray());
        a=a.replace(target, "");
        
        // Return the resultant string 
        this.setIngredientiPizza(a); 
        System.out.println("After the remove the string is : "+a);
        return a;
    }
	
	
	//metodo per aggiungere ingrediente alla pizza
	public String addIngrediente(String word){ 
		String a = this.getIngredienti();
        this.setIngredientiPizza(a+"/"+word); 
        System.out.println("After the remove the string is : "+a);
        return a;
    }
}
