<%@page import="java.util.List"%>
<%@page import="com.dxc.hotel.HotelCrud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HotelCrud obj=new HotelCrud();
    String bid=obj.generateBookID();
%>
	<form method="get" action="BookingComplete.jsp">
		<center>
			Book ID : 
			<input type="text" name="bookId" 
				readonly="readonly"
			value="<%=bid %>" /> <br/> <br/>
			Select Room : 
			 <select name="roomId">
	<%
		HotelCrud cr=new HotelCrud();
	    List<String> lst=cr.available();
	    for(String s : lst){
	    	//out.println(s); 
     %>
     <br/>
    
		<option value="<%=s%>"><%=s%> </option>
		
     <%
	    }
	%>
		</select><br/>
			
			<br/>
			Customer Name : 
			<input type="text" name="custName" /> <br/><br/> 
			City : 
			<input type="text" name="city" /> <br/><br/> 
			Book Date : 
			<input type="date" name="bookDate" /> <br/><br/> 
			<input type="submit" value="Book Room" />
		</center>
	</form>
</body>
</html>