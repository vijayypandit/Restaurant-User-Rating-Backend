package com.codeoverflow.rating.controller;

import java.util.List;

import com.codeoverflow.rating.entities.Rating;
import com.codeoverflow.rating.services.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // create ratings
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    // get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    // get all ratings
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    // get all ratings
    @GetMapping("/restaurants/{restaurantId}")

    public ResponseEntity<List<Rating>> getRatingsByRestaurantId(@PathVariable String restaurantId) {
        return ResponseEntity.ok(ratingService.getRatingByRestaurantId(restaurantId));
    }

}
