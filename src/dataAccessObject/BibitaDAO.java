package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Bibita;

public class BibitaDAO {

		public static ObservableList<Bibita> getAllRecords() throws SQLException, ClassNotFoundException{
			String sql ="select * from Bibita";
			try {
				ResultSet rsSet =  DBUtil.dbExecute(sql);
				ObservableList<Bibita> bibitaList =  getBibitaObject(rsSet);
				return bibitaList;

			}catch(SQLException e){
				System.out.println("Error occured while get all the record "+e);
				e.printStackTrace();
				throw e;
			}
		}
		
		public static ObservableList<Bibita> getAllRecordsAggiorna(String txt) throws SQLException, ClassNotFoundException{
			String sql ="select * from Pizza where nome_pizza LIKE"+"'%"+ txt +"%';" ;
			try {
				ResultSet rsSet =  DBUtil.dbExecute(sql);
				ObservableList<Bibita> bibitaList =  getBibitaObject(rsSet);
				return bibitaList;

			}catch(SQLException e){
				System.out.println("Error occured while get all the record updated "+e);
				e.printStackTrace();
				throw e;
			}
		}

		
		private static ObservableList<Bibita> getBibitaObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
			try {
				ObservableList<Bibita> bibitaList = FXCollections.observableArrayList();
				while(rsSet.next()) {
					Bibita bibita = new Bibita();
					bibita.setNomeBibita(rsSet.getString("nome_bibita"));
					bibita.setPrezzo(rsSet.getFloat("sovraprezzo"));
					bibitaList.add(bibita);
				}
				
				return bibitaList;
			}catch(SQLException e) {
				System.out.println("Error occured while fetching the data from DB "+e);
				e.printStackTrace();
				throw e;
			}
		}
		
		public static ObservableList<Bibita> searchBibita(String nomeBibita) throws SQLException,ClassNotFoundException{
			String sql = "select * from Bibita where nome_bibita = " + nomeBibita;
			try {
				ResultSet rsSet = DBUtil.dbExecute(sql);
				ObservableList<Bibita> bibitaListSearch =  getBibitaObject(rsSet);
				System.out.println("Bibite ritornate " + bibitaListSearch);
				return bibitaListSearch;
			}
			catch(SQLException e) {
				System.out.println("Error occured while searching Bibite " + e);
				e.printStackTrace();
				throw e;
			}
		}
	
	
}
