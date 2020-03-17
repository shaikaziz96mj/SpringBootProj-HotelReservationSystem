package com.ss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dto.GuestDTO;
import com.ss.entity.GuestEntity;
import com.ss.repo.HotelReservationRepo;

@Service("hotelService")
public class HotelMgmtServiceImpl implements HotelMgmtService {

	@Autowired
	private HotelReservationRepo guestRepo;
	
	@Override
	public List<GuestDTO> getAllGuestList() {
		Iterable<GuestEntity> it=null;
		List<GuestDTO> listDTO=new ArrayList<GuestDTO>();
		//use repository
		it=guestRepo.findAll();
		//copy all entity to dto
		it.forEach(entity->{
			GuestDTO dto=new GuestDTO();
			//copying each entity to dto
			BeanUtils.copyProperties(entity, dto);
			//adding serial number in list
			dto.setSerialNo(listDTO.size()+1);
			//adding dto to list
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public String addGuest(GuestDTO dto) {
		GuestEntity entity=null;
		//copy dto to entity
		entity=new GuestEntity();
		BeanUtils.copyProperties(dto, entity);
		//use repository
		entity=guestRepo.save(entity);
		return (entity==null)?"Insertion failed":"Record Inserted Successfully";
	}
	
	@Override
	public GuestDTO getGuestRecordById(int id) {
		Optional<GuestEntity> opt=null;
		GuestEntity entity=null;
		GuestDTO dto=null;
		//use repository
		opt=guestRepo.findById(id);
		//copy to entity 
		entity=new GuestEntity();
		if(opt.isPresent())
			entity=opt.get();
		//copy entity to dto
		dto=new GuestDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String modifyGuestRecord(GuestDTO dto) {
		GuestEntity entity=null;
		int count=0;
		//copy dto to entity
		entity=new GuestEntity();
		BeanUtils.copyProperties(dto, entity);
		//use repository
		count=guestRepo.updateGuestRecord(entity.getGuestName(), entity.getGuestAddress(), entity.getGuestAge(), entity.getCheckedIn(),entity.getCheckedOut() , entity.getGuestId(),entity.getPhoneNumber());
		return (count==0)?"Record not updated":"Record Updated";
	}
	
	@Override
	public String deleteGuestRecord(int id) {
		//use repository
		guestRepo.deleteById(id);
		return "Record Deleted";
	}

}//class