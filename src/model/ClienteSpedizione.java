package model;

public class ClienteSpedizione extends ClienteAsporto {
	private String indirizzo;
	private int numeroCivico;
	private int numeroTelefono;
	
	public ClienteSpedizione(String[] nomiPizze, int numTavolo, String nomeCliente, int orario, String indirizzo, int numeroCivico, int numeroTelefono) {
		//numTavolo=0 perché non mangia in un tavolo
		super(nomiPizze, 0, nomeCliente, orario);
		this.indirizzo = indirizzo;
		this.numeroCivico = numeroCivico;
		this.numeroTelefono = numeroTelefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public int getNumeroCivico() {
		return numeroCivico;
	}
	
	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

}
