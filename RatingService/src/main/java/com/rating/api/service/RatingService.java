package com.rating.api.service;

import java.util.List;

import com.rating.api.entity.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	Rating getById(Long id);
	List<Rating> getByUserId(Long id);
	List<Rating> getByHotelId(Long id);
	List<Rating> getAll();

}
