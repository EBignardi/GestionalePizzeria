package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtil.DBUtil;

public class ClienteDAO {
	public static void insertCliente(String nomeCliente, String telefono, String indirizzo, String civico)throws SQLException, ClassNotFoundException {
		String sql = "insert into Cliente(nome, indirizzo, civico, telefono) "
				+ "values ('"+ nomeCliente +"','"+ indirizzo +"','"+ civico +"','"+ telefono +"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Query che estrapola il NUMERO di ordini mensili
	 * */	
	public static int[] ordiniPerMese() throws SQLException, ClassNotFoundException {
		String sql = "SELECT count(*) as ordini_mensili FROM Ordine GROUP BY strftime('%m',data); ";
		try {
			DBUtil.dbExcecuteQuery(sql);
			ResultSet rsSet = DBUtil.dbExecute(sql);
			
			int[] ordiniMese = new int[12];
			int i = 0;
			
			while(rsSet.next()) {
					ordiniMese[i] = (rsSet.getInt("ordini_mensili"));
					i++;
				}
			
			return ordiniMese ;
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data " + e);
			e.printStackTrace();
			throw e;
		}

	}
	
	/**
	 * Query che estrapola il FATTURATO mensile
	 * */	
	public static float[] fatturatoPerMese() throws SQLException, ClassNotFoundException {
		String sql = "SELECT sum(prezzo_totale) as fatturato_mensile FROM Ordine GROUP BY strftime('%m',data); ";
		try {
			DBUtil.dbExcecuteQuery(sql);
			ResultSet rsSet = DBUtil.dbExecute(sql);
			
			float[] fatturatoMese = new float[12];
			int i = 0;
			
			while(rsSet.next()) {
					fatturatoMese[i] = (rsSet.getFloat("fatturato_mensile"));
					i++;
				}
			
			return fatturatoMese ;
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data " + e);
			e.printStackTrace();
			throw e;
		}

	}
	
	/**
	 * Query che estrapola i primi 3 clienti per soldi spesi
	 * */	
	public static List<String> topClienti() throws SQLException, ClassNotFoundException {
		String sql = "SELECT nome_cliente, sum(prezzo_totale) as soldi_spesi FROM Ordine GROUP BY nome_cliente ORDER BY soldi_spesi DESC LIMIT 3; ";
		try {
			DBUtil.dbExcecuteQuery(sql);
			ResultSet rsSet = DBUtil.dbExecute(sql);
			
			List<String> topClienti = new ArrayList<String>();

			while(rsSet.next()) {
					topClienti.add(rsSet.getString("nome_cliente"));
				}
			return topClienti ;
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data " + e);
			e.printStackTrace();
			throw e;
		}

	}
	
	/**
	 * Query che estrapola le prime 3 pizze 
	 * */	
	public static List<String> topPizze() throws SQLException, ClassNotFoundException {
		String sql = "SELECT nome_pizza, sum(quantita) as numero_pizze FROM OrdinePizza GROUP BY nome_pizza ORDER BY numero_pizze DESC LIMIT 3; ";
		try {
			DBUtil.dbExcecuteQuery(sql);
			ResultSet rsSet = DBUtil.dbExecute(sql);
			
			List<String> topPizze = new ArrayList<String>();

			while(rsSet.next()) {
					topPizze.add(rsSet.getString("nome_pizza"));
				}
			return topPizze ;
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data " + e);
			e.printStackTrace();
			throw e;
		}

	}
}
