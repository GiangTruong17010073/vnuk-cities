package vn.edu.vnuk.cities.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.cities.dao.CityDao;
import vn.edu.vnuk.cities.model.City;

@WebServlet("/addCity")
@SuppressWarnings("serial")
public class AddCityServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String nameCity = request.getParameter("city");
		String province = request.getParameter("province");
		String zipCodeInStringFormat = request.getParameter("zip_code");
		
		Long zipCode = Long.parseLong(zipCodeInStringFormat);
		
		City city = new City();
		city.setCity(nameCity);
		city.setProvince(province);
		city.setZipCode(zipCode);
		
		CityDao cityDao = new CityDao();
		try {
			cityDao.create(city);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("City " + city.getCity() + " successfully added!");
		out.println("<div>");
		out.println("<a href = \"http://localhost:8080/vnuk-cities/cities.jsp\">");
		out.println("Display cities!");
		out.println("</a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
