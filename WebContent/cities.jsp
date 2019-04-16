<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*,
	vn.edu.vnuk.cities.dao.CityDao,
	vn.edu.vnuk.cities.model.City"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet"  type="text/css" href="css/cities-table.css">
</head>
<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<c:import url="header.jsp" />
		
		<jsp:useBean class="vn.edu.vnuk.cities.dao.CityDao" id="dao"/>
			
		<table>
			<tr>
				<th>City</th>
				<th>Province</th>
				<th>Zip Code</th>
			</tr>
			<c:forEach var="eachCity" items="${dao.read() }" varStatus="index"  >
				<tr>
                        <td> ${eachCity.city} </td>
                        <td> ${eachCity.province} </td>
                        <td> ${eachCity.zipCode} </td>
                      
                    </tr>
			</c:forEach>
		</table>
		
		<div>
			<a href = "http://localhost:8080/vnuk-cities/add-city.jsp">
				Add a city
			</a>
		</div>	
	
		
		<c:import url="footer.jsp" />
</body>
</html>