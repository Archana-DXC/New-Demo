package com.dxc.hotel;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@Column(name="BookId")
	private String BookId;
	
	@Column(name="RoomID")
	private String RoomID;
	
	@Column(name="CustName")
	private String   CustName;
	
	@Column(name="City")
	private String City;
	
	@Column(name="BookDate")
	private Timestamp   BookDate;
	
	@Column(name="ChkDate")
	private Timestamp   ChkDate;

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Timestamp getBookDate() {
		return BookDate;
	}

	public void setBookDate(Timestamp bookDate) {
		BookDate = bookDate;
	}

	public Timestamp getChkDate() {
		return ChkDate;
	}

	public void setChkDate(Timestamp chkDate) {
		ChkDate = chkDate;
	}

}
