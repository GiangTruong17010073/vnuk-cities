package vn.edu.vnuk.cities.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class Sql2010CreateCities {
	private final Connection connection;
	private final String sqlQuery;
	
	public Sql2010CreateCities(Connection connection) {
		this.connection = connection;
		
		this.sqlQuery = "CREATE TABLE IF NOT EXISTS cities ("
				+ 	"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+ 	"city VARCHAR(255) NOT NULL, "
				+ 	"province VARCHAR(255) NOT NULL, "
				+ 	"zip_code INT NOT NULL "
				+ ");"
			;
	}
	
	public void run() throws SQLException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(">  Sql2010CreateCities started");
		
		try {
	        connection.prepareStatement(sqlQuery).execute();
	        System.out.println("   TABLE \'cities\' successfully created");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql2010CreateCities ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
}
