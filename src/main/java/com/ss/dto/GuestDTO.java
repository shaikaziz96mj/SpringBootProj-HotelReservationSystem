package com.ss.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GuestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int serialNo;
	private int guestId;
	private String guestName;
	private int guestAge;
	private String guestAddress;
	private long phoneNumber;
	private int roomNumber;
	private Date checkedIn;
	private Date checkedOut;
		
}