package com.hotel.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entity.Hotel;
import com.hotel.api.exception.ResourceNotFoundException;
import com.hotel.api.repository.HotelRepository;
import com.hotel.api.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getById(Long id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

}
