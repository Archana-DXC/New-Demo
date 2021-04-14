package com.dxc.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreateRoom")

public class CreateRoom {
	
	@Id
	@Column(name="roomType")
	private String roomType;
	
	@Column(name="costPerDay")
	private int costPerDay;
	
	@Column(name="status")
	private String  status;

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
