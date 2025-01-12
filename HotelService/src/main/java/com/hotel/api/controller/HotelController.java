package com.hotel.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.entity.Hotel;
import com.hotel.api.service.HotelService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add")
	Map<String, Object> createHotel(@RequestBody Hotel hotel){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", hotelService.create(hotel));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getById/{id}")
	Map<String, Object> createHotel(@PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", hotelService.getById(id));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getAll")
	Map<String, Object> getAll(){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", hotelService.getAll());
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}

}
