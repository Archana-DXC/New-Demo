package com.dxc.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Billing")
public class Billing {
	
	@Id
	@Column(name="BookID")
	private String BookID;
	
	@Column(name="RoomID")
	private String RoomID;
	
	@Column(name="NoOfDays")
	private int NoOfDays;
    
	@Column(name="BillAmount")
	private int BillAmount;

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public int getNoOfDays() {
		return NoOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		NoOfDays = noOfDays;
	}

	public int getBillAmount() {
		return BillAmount;
	}

	public void setBillAmount(int billAmount) {
		BillAmount = billAmount;
	}
	
}
