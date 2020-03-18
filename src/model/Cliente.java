package model;

//**Classe pricipale
public class Cliente {
	private String[] nomiPizze;
	private int numTavolo;
	
	public Cliente(String[] pizza, int numTavolo) {
		super();
		this.nomiPizze = pizza;
		this.numTavolo = numTavolo;
	}

	public String[] getPizza() {
		return nomiPizze;
	}
	
	public void setPizza(String[] pizza) {
		this.nomiPizze = pizza;
	}

	public int getNumTavolo() {
		return numTavolo;
	}

	public void setNumTavolo(int numTavolo) {
		this.numTavolo = numTavolo;
	}
	
}
