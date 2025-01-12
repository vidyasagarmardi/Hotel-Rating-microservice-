package com.rating.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.api.entity.Rating;
import com.rating.api.exception.ResourceNotFoundException;
import com.rating.api.repository.RatingRepository;
import com.rating.api.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository repo;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return repo.save(rating);
	}

	@Override
	public Rating getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException());
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getByUserId(Long id) {
		// TODO Auto-generated method stub
		return repo.findByUserId(id);
	}

	@Override
	public List<Rating> getByHotelId(Long id) {
		// TODO Auto-generated method stub
		return repo.findByHotelId(id);
	}

}
