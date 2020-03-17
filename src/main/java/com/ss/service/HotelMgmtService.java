package com.ss.service;

import java.util.List;

import com.ss.dto.GuestDTO;

public interface HotelMgmtService {

	public List<GuestDTO> getAllGuestList();
	public String addGuest(GuestDTO dto);
	public GuestDTO getGuestRecordById(int id);
	public String modifyGuestRecord(GuestDTO dto);
	public String deleteGuestRecord(int id);
	
}