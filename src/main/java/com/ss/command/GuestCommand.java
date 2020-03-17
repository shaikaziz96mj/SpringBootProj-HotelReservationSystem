package com.ss.command;

import java.util.Date;

import lombok.Data;

@Data
public class GuestCommand{

	private int guestId;
	private String guestName;
	private int guestAge;
	private String guestAddress;
	private long phoneNumber;
	private int roomNumber;
	private Date checkedIn;
	private Date checkedOut;
		
}