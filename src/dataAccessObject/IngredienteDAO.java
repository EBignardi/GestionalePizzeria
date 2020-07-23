package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ingrediente;


public class IngredienteDAO {
	public static ObservableList<Ingrediente> getAllRecords() throws SQLException, ClassNotFoundException{
		String sql ="select * from Ingredienti";
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Ingrediente> ingredienteList =  getIngredienteObject(rsSet);
			return ingredienteList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Ingrediente> getAllRecordsAggiorna(String txt) throws SQLException, ClassNotFoundException{
		String sql ="select * from Ingredienti where nome_ingrediente LIKE"+"'%"+ txt +"%';" ;
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Ingrediente> IngredienteList =  getIngredienteObject(rsSet);
			return IngredienteList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record updated"+e);
			e.printStackTrace();
			throw e;
		}
	}

	
	private static ObservableList<Ingrediente> getIngredienteObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
		try {
			ObservableList<Ingrediente> ingredienteList = FXCollections.observableArrayList();
			while(rsSet.next()) {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setNomeIngrediente(rsSet.getString("nome_ingrediente"));
				ingrediente.setCosto(rsSet.getFloat("sovrapprezzo"));
				ingredienteList.add(ingrediente);
			}
			
			return ingredienteList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
}
