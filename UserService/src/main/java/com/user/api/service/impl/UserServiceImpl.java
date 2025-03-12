package com.user.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.api.entity.Hotel;
import com.user.api.entity.Rating;
import com.user.api.entity.User;
import com.user.api.exception.ResourceNotFoundException;
import com.user.api.repository.UserRepository;
import com.user.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		User reqUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());		
		
		try {
			String response = restTemplate.getForObject("http://RATING-SERVICE/rating/getByUserId/"+reqUser.getId(), String.class);
			Map<String, Object> resMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});
			List<Rating> ratings = objectMapper.convertValue(resMap.get("Data"), new TypeReference<List<Rating>>() {});
			List<Rating> ratingList = ratings.stream().map(rating -> {
				String resHotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/getById/"+rating.getHotelId(), String.class);
				Map<String, Object> hotelMap = new HashMap<>();
				try {
					hotelMap = objectMapper.readValue(resHotel, new TypeReference<Map<String, Object>>() {});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Response from hotel api : "+resHotel);
				Hotel hotel = objectMapper.convertValue(hotelMap.get("Data"), new TypeReference<Hotel>() {});
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			
			reqUser.setRatings(ratingList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reqUser;
	}

	@Override
	public List<User> getAllUsers() {
		 List<User> users = userRepo.findAll();
		 List<User> userList = new ArrayList<>();
		 try {
			userList = users.stream().map(user -> {
				String response = restTemplate.getForObject("http://RATING-SERVICE/rating/getByUserId/"+user.getId(), String.class);
				Map<String, Object> resMap = new HashMap<>();
				try {
					resMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				List<Rating> ratings = objectMapper.convertValue(resMap.get("Data"), new TypeReference<List<Rating>>() {});
				List<Rating> ratingList = ratings.stream().map(rating -> {
					String hotelres = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/getById/"+rating.getHotelId(), String.class);
					Map<String, Object> hotelMap = new HashMap<>();
					try {
						hotelMap = objectMapper.readValue(hotelres, new TypeReference<Map<String, Object>>() {});
					} catch (Exception e) {
						 System.out.println(e.getMessage());
					}
					Hotel hotel = objectMapper.convertValue(hotelMap.get("Data"), new TypeReference<Hotel>() {});
					rating.setHotel(hotel);
					return rating;
				}).collect(Collectors.toList());
				user.setRatings(ratingList);
				return user;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return userList;
	}

}
