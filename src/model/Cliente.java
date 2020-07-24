package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


//Classe pricipale per tutti i Clienti se il cliente e' da asporto i campi di indirizzo civico saranno vuoti
public class Cliente {
		protected StringProperty nomeCliente;
		protected StringProperty indirizzo;
		protected IntegerProperty numeroCivico;
		protected IntegerProperty numeroTelefono;
		
		
	//allocazione classe cliente senza input
	public Cliente() {
		this.nomeCliente = new SimpleStringProperty();
		this.indirizzo = new SimpleStringProperty();
		this.numeroCivico = new SimpleIntegerProperty();
		this.numeroTelefono = new SimpleIntegerProperty();
	}
		
	
	public Cliente( StringProperty nomeCliente,StringProperty indirizzo,IntegerProperty numeroCivico,IntegerProperty numeroTelefono) {
		this.setNomeCliente(nomeCliente);
		this.setIndirizzo(indirizzo);
		this.setNumeroCivico(numeroCivico);
		this.setNumeroTelefono(numeroTelefono);
	}
	
	
	public StringProperty getNomeCliente() {
		return indirizzo;
	}

	public void setNomeCliente(StringProperty indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	// metodi Indirizzo Cliente Spedizione
		public StringProperty getIndirizzoProperty() {
			return indirizzo;
		}

		public void setIndirizzo(StringProperty indirizzo) {
			this.indirizzo = indirizzo;
		}
		
		public String getIndirizzo() {
			return this.nomeCliente.get();
		}

		// metodi Numero Civico Cliente Spedizione
		public IntegerProperty getNumeroCivicoProperty() {
			return numeroCivico;
		}

		public void setNumeroCivico(IntegerProperty numeroCivico) {
			this.numeroCivico = numeroCivico;
		}

		public Integer getNumeroCivico() {
			return this.numeroCivico.get();
		}
		
		// metodi Numero Telefono Cliente Spedizione
		public IntegerProperty getNumeroTelefonoProperty() {
			return numeroTelefono;
		}

		public void setNumeroTelefono(IntegerProperty numeroTelefono) {
			this.numeroTelefono = numeroTelefono;
		}

		public Integer getNumeroTelefono() {
			return this.numeroTelefono.get();
		}
		

	
}
