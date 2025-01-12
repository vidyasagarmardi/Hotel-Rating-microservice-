package com.rating.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.api.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	List<Rating> findByUserId(Long id);
	List<Rating> findByHotelId(Long id);

}
