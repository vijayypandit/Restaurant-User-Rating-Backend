package com.codeoverflow.rating.impl;

import com.codeoverflow.rating.entities.Rating;
import com.codeoverflow.rating.repository.RatingRepository;
import com.codeoverflow.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByRestaurantId(String restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }
}
