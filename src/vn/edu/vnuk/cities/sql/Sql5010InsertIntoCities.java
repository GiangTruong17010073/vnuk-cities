package vn.edu.vnuk.cities.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sql5010InsertIntoCities {
	
	private final Connection connection;
	private final String sqlQuery;
	
	public Sql5010InsertIntoCities(Connection connection) {
		this.connection = connection;
		
		this.sqlQuery = "insert into cities (city, province, zip_code) "
                +	"values (?, ?, ?)";
	}
	
	public void run() throws SQLException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(">  Sql5010InsertIntoCategories started");
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setString(1, "Đà Nẵng");
            statement.setString(2, "Đà Nẵng thử dấu không lỗi");
            statement.setLong(3, 1284);

            // 	Executing statement
			statement.execute();
			statement.close();
	        System.out.println("   DATA successfully loaded in \'categories\'");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql5010InsertIntoCategories ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
}
