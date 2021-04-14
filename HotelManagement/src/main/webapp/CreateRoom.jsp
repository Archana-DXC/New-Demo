<%@page import="com.dxc.hotel.HotelCrud"%>
<%@page import="com.dxc.hotel.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean1" class="com.dxc.hotel.CreateRoom"/>
<jsp:setProperty property="*" name="bean1"/>
<%

Room objRoom=new Room();
objRoom.setType(bean1.getRoomType());
objRoom.setCostPerDay(bean1.getCostPerDay());
objRoom.setStatus(bean1.getStatus());
HotelCrud obj=new HotelCrud();

out.println(obj.generateRoomID());

out.println(obj.addRoom(objRoom));

 
%>



</body>
</html>