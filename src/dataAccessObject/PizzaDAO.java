package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pizza;


public class PizzaDAO {
	public static void insertPizza(String nomePizza, double prezzo, String ingredienti)throws SQLException, ClassNotFoundException {
		String sql = "insert into pizza(nomePizza, prezzo, ingredienti) values ('"+nomePizza+"','"+ prezzo +"','"+ ingredienti +"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void updatePizza(String nomePizza, String idPizza) throws SQLException, ClassNotFoundException{
		String sql ="update Pizza set nomePizza = '"+ nomePizza +"' where idPizza = '"+ idPizza +"' ";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while updating the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void deletePizzaById(int idPizza) throws SQLException, ClassNotFoundException{
		String sql ="delete from Pizza where id = '"+ idPizza +"'";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while deleting the record "+e);
			e.printStackTrace();
			throw e;
		}
	}

	//REFRESH ALL
	public static ObservableList<Pizza> getAllRecords() throws SQLException, ClassNotFoundException{
		String sql ="select * from Pizza";
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Pizza> pizzaList =  getPizzaObject(rsSet);
			return pizzaList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Pizza> getAllRecordsAggiorna(String txt) throws SQLException, ClassNotFoundException{
		String sql ="select * from Pizza where nomePizza LIKE"+"'%"+ txt +"%';" ;
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Pizza> pizzaList =  getPizzaObject(rsSet);
			return pizzaList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record updated "+e);
			e.printStackTrace();
			throw e;
		}
	}

	
	private static ObservableList<Pizza> getPizzaObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
		try {
			ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();
			while(rsSet.next()) {
				Pizza pizza = new Pizza();
				pizza.setNomePizza(rsSet.getString("nomePizza"));
				pizza.setPrezzo(rsSet.getFloat("prezzo"));
				pizza.setIngredienti(rsSet.getString("ingredienti"));
				pizzaList.add(pizza);
			}
			
			return pizzaList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Pizza> searchPizza(String nomePizza) throws SQLException,ClassNotFoundException{
		String sql = "select * from Pizza where nomePizza = " + nomePizza;
		try {
			ResultSet rsSet = DBUtil.dbExecute(sql);
			ObservableList<Pizza> pizzaListSearch =  getPizzaObject(rsSet);
			System.out.println("Pizze ritornate " + pizzaListSearch);
			return pizzaListSearch;
		}
		catch(SQLException e) {
			System.out.println("Error occured while searching Pizza " + e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Pizza> searchIngredientiPizza(String nomePizza) throws SQLException,ClassNotFoundException{
		String sql = "select ingredienti from Pizza where nomePizza = " + nomePizza;
		try {
			ResultSet rsSet = DBUtil.dbExecute(sql);
			ObservableList<Pizza> pizzaIngredientiSearch =  getPizzaObject(rsSet);
			System.out.println("Ingredienti ritornati " + pizzaIngredientiSearch);
			return pizzaIngredientiSearch;
		}
		catch(SQLException e) {
			System.out.println("Error occured while searching Ingredienti Pizza " + e);
			e.printStackTrace();
			throw e;
		}
	}
}
