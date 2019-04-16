package vn.edu.vnuk.cities.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.cities.jdbc.ConnectionFactory;

@SuppressWarnings("serial")
@WebServlet ("/test-connection")
public class TestConnectionServlet extends HttpServlet {
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
        try {
        	Connection connection = new ConnectionFactory().getConnection();
            
        	out.println("Connection is open!");
            connection.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
            out.println("Done");
        }
    }
}
