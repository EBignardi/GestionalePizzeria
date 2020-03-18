package dbUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;

import javax.sql.rowset.*; 


public class DBUtil {
	private static final String JDBC_DRIVER = "org.sqlite.JDBC";
	private static Connection conn = null;
	private static final String connStr = "jdbc:sqlite:Prova01";
	
	public static void dbConnect() throws SQLException,ClassNotFoundException{
		try {
			Class.forName(JDBC_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Where is your mysql jdbc driver?");
			e.printStackTrace();
			throw e;
		}
		
		System.out.println("JDBC Driver has been registered");
		try {
			conn = DriverManager.getConnection(connStr);
			System.out.println(conn);
		}
		catch(SQLException e) {
			System.out.println("Connection failed Check output console: "+e);
			throw e;
		}
	}
	
	public static void dbDisconnect() throws  SQLException{
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public static void dbExcecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException{
		Statement stmt = null;
		try {
				dbConnect();
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlStmt);
		}
		catch(SQLException e) {
			System.out.println("Problem occurred at dbExecuteQuery op "+e);
			throw e;
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			dbDisconnect();
		}
	}
	
	
	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		try {
			dbConnect();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(sqlQuery);
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
		}
		catch(SQLException e) {
			System.out.println("Error occure in dbExecute Op. "+e);
			throw e;
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			dbDisconnect();
		}
		return crs;
	}
}
