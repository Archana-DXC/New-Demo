package com.dxc.hotel;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HotelCrud {
	
	public String bookRoom(Booking objBooking){
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		objBooking.setBookId(generateBookID());
		s.save(objBooking);
		Room r=(Room)s.get(Room.class,objBooking.getRoomID());
		r.setStatus("Booked...");
		s.update(r);
		return "Room Booked...";
		
	}
	
	public List<Room> showRoom() {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		   List<Room> lstRoom=s.find("from Room");
		    return lstRoom;

		}
		
	
	
	public List<String> available() {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		List<Room> lstBook=s.find("from Room where status='Available'");
	    List<String> lstAvail=new ArrayList<String>();
	    for(Room b : lstBook){
	    	lstAvail.add(b.getRoomID());
	    }
	    return lstAvail;
	}
	
	
	
	public String getRoomID(String bookID){
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Booking b=(Booking)s.get(Booking.class,bookID);
		String rid=b.getRoomID();
		return rid;
		
	}
	
	public String roomChkDate(String bookID,Timestamp chkDate) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Booking b=(Booking)s.get(Booking.class,bookID); 
		b.setChkDate(chkDate); 
		s.update(b); 
		return "Checkout Complete";
	}
		
	
	
	public String roomStatusChange(String bookID) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Booking b=(Booking)s.get(Booking.class,bookID);
		String rid=b.getRoomID();
		Room r=(Room)s.get(Room.class,rid);
		r.setStatus("Available");
		s.update(r);
		return r.getStatus();
	}
		
		
	
	public int billAmount(String bookID) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Booking b=(Booking)s.get(Booking.class,bookID);
		String rid=b.getRoomID();
		Room r=(Room)s.get(Room.class,rid); 
		int price=r.getCostPerDay(); 
		int total=price* noOfDays(bookID); 
		return total;
		
	}
	
	public int noOfDays(String bookID) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		List lst=s.find("select DATEDIFF(ChkDate,BookDate) from Booking where bookId='"+bookID+"'");
		int days=0;
		for(Object ob : lst){
			days=(Integer)ob;
		}
		return days;
		
	}
	
	
	public String finalBook(Billing billing) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(billing);
		t.commit();
		return "Bill Over...";
	}
	
	public String addBooking(Booking booking) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(booking);
		t.commit();
		return "Record added....";
	}
	
	public String addRoom(Room room) {
		SessionFactory sf=SessionHelper.getFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(room);
		t.commit();
		return "Room added successfully";
	}
	public String generateRoomID() {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Room");
		List<Room> clist = q.list();
		String code="";
		String result = "R001";
		if (clist.size() > 0) {
			for (Room r : clist) {
				code = r.getRoomID();
			}
			int id = Integer.parseInt(code.substring(1));
			id++;
		
			if (id >= 1 && id <= 9) {
				result = "R00"+id;
			}
			if (id >=10 && id <= 99) {
				result = "R0" +id;
			}
			if (id >=100 && id <=999) {
				result = "R"+id;
			}

		}
		return result;
	}
	public String generateBookID() {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Booking");
		List<Booking> clist = q.list();
		String code="";
		String result = "B001";
		if (clist.size() > 0) {
			for (Booking b : clist) {
				code = b.getBookId();
			}
			int id = Integer.parseInt(code.substring(1));
			id++;
			if (id >= 1 && id <= 9) {
				result = "B00"+id;
			}
			if (id >=10 && id <= 99) {
				result = "B0" +id;
			}
			if (id >=100 && id <=999) {
				result = "B"+id;
			}

		}
		return result;
	}


}
