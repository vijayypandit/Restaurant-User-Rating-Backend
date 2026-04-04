package com.codeoverflow.rating.repository;

import com.codeoverflow.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    //custom finder method


    List<Rating> findByUserId(String userId);

    List<Rating> findByRestaurantId(String restaurantId);

}
