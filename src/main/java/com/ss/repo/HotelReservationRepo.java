package com.ss.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ss.entity.GuestEntity;

public interface HotelReservationRepo extends CrudRepository<GuestEntity, Integer> {

	@Modifying
	@Query("Update GuestEntity set guestName=:name,guestAge=:age,phoneNumber=:number,guestAddress=:address,checkedIn=:in,checkedOut=:out WHERE guestId=:id")
	public int updateGuestRecord(@Param("name")String name,@Param("address")String address,@Param("age")int age,@Param("in")Date in,@Param("out")Date out,@Param("id")int id,@Param("number")long number);
	
}