package com.hotel.api.service;

import java.util.List;

import com.hotel.api.entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	Hotel getById(Long id);
	List<Hotel> getAll();

}
