package com.codeoverflow.user.service;

import com.codeoverflow.user.service.entities.Rating;
import com.codeoverflow.user.service.external.services.RatingService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating() {
		Rating rating = new Rating(null, "", "", 10, "Good Food", null);
		org.springframework.http.ResponseEntity<Rating> savedrating = ratingService.createRating(rating);
		System.out.println(" NEW Rating created successfully");
	}

}
