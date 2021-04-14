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
	<jsp:useBean id="bean1" class="com.dxc.hotel.Billing" />
	<jsp:setProperty property="*" name="bean1" />
	<%
		HotelCrud obj=new HotelCrud();
		out.println(bean1.getRoomID());
		out.println(obj.roomStatusChange(bean1.getBookID()));
		obj.finalBook(bean1);
		
	%>
</body>
</html>