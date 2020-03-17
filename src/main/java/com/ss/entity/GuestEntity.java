package com.ss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "HOTEL_GUEST")
public class GuestEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 5)
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int guestId;
	@Column(length = 20)
	@Type(type="string")
	private String guestName;
	@Column(length = 5)
	@Type(type="int")
	private int guestAge;
	@Column(length = 50)
	@Type(type="string")
	private String guestAddress;
	@Column(length = 15)
	@Type(type="long")
	private long phoneNumber;
	@Column(length = 5)
	@Type(type="int")
	private int roomNumber;
	@Column()
	@Type(type="date")
	private Date checkedIn;
	@Column()
	@Type(type="date")
	private Date checkedOut;
	
	
}