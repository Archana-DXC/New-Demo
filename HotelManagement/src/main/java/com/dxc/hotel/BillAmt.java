package com.dxc.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BillAmt")
public class BillAmt {
	
	@Id
	@Column(name="noOfDays")
	private int noOfDays;
    
	@Column(name="billAmt")
	private int billAmt;

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(int billAmt) {
		this.billAmt = billAmt;
	}
	
}
