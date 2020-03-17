package com.ss.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ss.command.GuestCommand;
import com.ss.dto.GuestDTO;
import com.ss.service.HotelMgmtService;

@Controller
public class HotelSystemMainController {
	
	@Autowired
	private HotelMgmtService service;

	//displaying welcome page
	@RequestMapping("/welcome.htm")
	public String getWelcomePage() {
		return "welcome_page";
	}
	
	//displaying home page
	@RequestMapping("/getdetails.htm")
	public String getHomePageWithAllGuestList(Map<String,Object>map) {
		List<GuestDTO> listDTO=null;
		//use service
		listDTO=service.getAllGuestList();
		//return model and view
		map.put("listDTO", listDTO);
		return "home_page";
	}
	
	//displaying insert form >Initial phase request
	@GetMapping("/insert_guest.htm")
	public String insertGuestForm(@ModelAttribute(name="guestCmd")GuestCommand cmd) {
		return "insert_form";
	}
	
	//method to bind date values
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	//inserting new record >PostBack request
	@PostMapping("/insert_guest.htm")
	public String insertGuest(RedirectAttributes attributes,@ModelAttribute(name="guestCmd")GuestCommand cmd,BindingResult errors) {
		GuestDTO dto=null;
		String resultMsg=null;
		List<GuestDTO> listDTO=null;
		//copy cmd to dto
		dto=new GuestDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		resultMsg=service.addGuest(dto);
		listDTO=service.getAllGuestList();
		//return model and view
		attributes.addFlashAttribute("result",resultMsg);
		attributes.addFlashAttribute("listDTO",listDTO);
		return "redirect:/post_insert.htm"; 
	}
	
	//POST REDIRECTING to avoid double posting problem 
	@GetMapping("/post_insert.htm")
	public String avoidDoublePost() {
		return "home_page";
	}
	
	//displaying record to be edited >Initial phase request
	@GetMapping("/edit_record.htm")
	public String getGuestDetailsById(@ModelAttribute("guestCmd")GuestCommand cmd,HttpServletRequest req) {
		int id=0;
		GuestDTO dto=null;
		//get additional request parameter
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		dto=service.getGuestRecordById(id);
		//copy dto to command
		BeanUtils.copyProperties(dto, cmd);
		return "edit_guest";
	}
	
	//submitting updated record >PostBack request
	@PostMapping("/edit_record.htm")
	public String updateRecord(Map<String,Object>map,@ModelAttribute("guestCmd")GuestCommand cmd,BindingResult errors) {
		GuestDTO dto=null;
		String resultMsg=null;
		List<GuestDTO> listDTO=null;
		//copy cmd to dto
		dto=new GuestDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		resultMsg=service.modifyGuestRecord(dto);
		listDTO=service.getAllGuestList();
		//return model and view
		map.put("result", resultMsg);
		map.put("listDTO", listDTO);
		return "home_page";
	}
	
	//deleting record
	@RequestMapping("/remove_record.htm")
	public String removeGuestRecord(Map<String,Object>map,HttpServletRequest req) {
		int id=0;
		List<GuestDTO> listDTO=null;
		String resultMsg=null;
		//get additional request parameter
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		resultMsg=service.deleteGuestRecord(id);
		listDTO=service.getAllGuestList();
		//return model and view
		map.put("result", resultMsg);
		map.put("listDTO", listDTO);
		
		return "home_page";
	}
}