<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dxc.hotel.HotelCrud"%>
<%@page import="com.dxc.hotel.Booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="bean1" class="com.dxc.hotel.BookRoom"/>
<jsp:setProperty property="*" name="bean1"/>
<%

Booking objRoom=new Booking();
out.println(bean1.getBookDate() + "<br/>");
java.sql.Date sqlDate = java.sql.Date.valueOf(bean1.getBookDate());
out.println(sqlDate);
objRoom.setCustName(bean1.getCustName());
objRoom.setCity(bean1.getCity());
objRoom.setRoomID(bean1.getRoomId());

HotelCrud obj=new HotelCrud();

out.println(obj.generateBookID());

out.println(obj.bookRoom(objRoom)); 

 
%>

</body>
</html>