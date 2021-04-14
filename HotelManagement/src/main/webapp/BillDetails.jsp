<%@page import="com.dxc.hotel.HotelCrud"%>
<%@page import="java.sql.Timestamp"%>
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
	
		String bid=request.getParameter("bookId");
	java.sql.Date sqlDate = java.sql.Date.valueOf(request.getParameter("chkDate"));
	out.println(bid);
	out.println(sqlDate);
	
	%>

	<%
		HotelCrud obj=new HotelCrud();
		int days=obj.noOfDays(bid);
		int amount=obj.billAmount(bid); 
		String rid=obj.getRoomID(bid);
		
	%>
	<form method="post" action="FinalBillReceipt.jsp">
	<Center>
		Book Id :
	<input type="text" name="bookId" value="<%=bid %>" readonly="readonly" />
	<br/><br/> 
	Room ID : 
	<input type="text" name="roomId" readonly="readonly"
		value="<%=rid %>"
	 /> <br/><br/>  
	No.of Days : 
	<input type="text" name="noOfDays" value="<%=days %>" 
		readonly="readonly" /> <br/><br/> 
	Bill Amount : 
	<input type="text" name="billAmt" 
		value="<%=amount %>" readonly="readonly" />
	<br/><br/>
	<input type="submit" value="Submit" />
	</Center> 
	</form>
</body>
</html>