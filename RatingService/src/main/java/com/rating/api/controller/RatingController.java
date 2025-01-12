package com.rating.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.api.entity.Rating;
import com.rating.api.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@PostMapping("/add")
	Map<String, Object> addRating(@RequestBody Rating rating){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.create(rating));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getById/{id}")
	Map<String, Object> getById(@PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getById(id));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getAll")
	Map<String, Object> getAllRatings(){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getAll());
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getByUserId/{userId}")
	Map<String, Object> getByUserId(@PathVariable Long userId){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getByUserId(userId));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getByHotelId/{hotelId}")
	Map<String, Object> getAllRatings(@PathVariable Long hotelId){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getByHotelId(hotelId));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}

}
