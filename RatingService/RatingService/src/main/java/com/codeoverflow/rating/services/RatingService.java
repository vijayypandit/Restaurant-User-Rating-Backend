package com.codeoverflow.rating.services;

import com.codeoverflow.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by userid
    List<Rating> getRatingByUserId(String userId);

    //get all by restaurant id
    List<Rating> getRatingByRestaurantId(String restaurantId);


}
