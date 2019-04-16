package vn.edu.vnuk.cities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.vnuk.cities.jdbc.ConnectionFactory;
import vn.edu.vnuk.cities.model.City;

public class CityDao {
	private Connection connection; 
	
	public CityDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void create(City city) throws SQLException {
		
		String sqlQuery = "insert into cities (city, province, zip_code) "
                +	"values (?, ?, ?)";
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setString(1, city.getCity());
            statement.setString(2, city.getProvince());
            statement.setLong(3, city.getZipCode());
           

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
@SuppressWarnings("finally")
public List<City> read() throws SQLException{
		
		PreparedStatement statement;
		String sqlQuery = "select * from cities";
		List<City> cities = new ArrayList<City>();
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            // 	Executing statement
			ResultSet results = statement.executeQuery();
			
			while (results.next()) {
				cities.add(buildCity(results));
			}
			
			results.close();
			statement.close();
			
			
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
	
			connection.close();
			return cities;
		}
	}

	@SuppressWarnings("finally")
	public City read(Long id) throws SQLException{
		
		String sqlQuery = "select * from cities where id = " + id + ";";
		
		PreparedStatement statement;
		City city = new City();
		try {
			statement = connection.prepareStatement(sqlQuery);
	
	        // 	Executing statement
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				city = buildCity(result);
			}
			
			result.close();
			statement.close();
			
		}
		catch(Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
	
		finally {
			return city;
		}
	}

	public void update (Long id, City city) throws SQLException {	
		City cityExist = new City();
		
		String sqlQuery = "update cities set city = ?, province = ?, zip_code = ? where id = " + id + ";";
		
		PreparedStatement statement;
		
		try {
			cityExist = read(id);
			statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1, city.getCity());
			statement.setString(2, city.getProvince());
			statement.setLong(3, city.getZipCode());
				
			if(cityExist != null) {
				int rowsUpdated = statement.executeUpdate();
				
				if(rowsUpdated > 0) {
					System.out.println("UPDATE ID: " + id);
				} else {
					System.out.println("ID NOT EXIST!");
				}
			} else {
				System.out.println("ID NOT EXIST!");
			}
			
			statement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			connection.close();
		}
		
		finally {
			connection.close();
		}
	}


	public void delete (Long id) throws SQLException {
		
		String sqlQuery = "delete from cities where id = " + id + ";" ;
		
		PreparedStatement statement;
	
		try {

			statement = connection.prepareStatement(sqlQuery);
	        
			int checkExist = statement.executeUpdate();
			
			if (checkExist != 0) {
				System.out.println("DELETED ID: " + id);
			}
			else 
				System.out.println("ID NOT EXIST!");

			statement.close();
		}
		catch(Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
	
		finally {
			connection.close();
		}
		
		
	}
	private City buildCity(ResultSet results) throws SQLException {
		City city = new City();
		city.setId(results.getLong("id"));
		city.setCity(results.getString("city"));
		city.setProvince(results.getString("province"));
		city.setZipCode(results.getLong("zip_code"));
		
		return city;
	}
}
