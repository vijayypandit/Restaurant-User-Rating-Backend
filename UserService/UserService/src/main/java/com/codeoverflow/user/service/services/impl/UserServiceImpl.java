package com.codeoverflow.user.service.services.impl;

import com.codeoverflow.user.service.entities.Rating;
import com.codeoverflow.user.service.entities.Restaurant;
import com.codeoverflow.user.service.entities.User;
import com.codeoverflow.user.service.exceptions.ResourceNotFoundException;
import com.codeoverflow.user.service.external.services.RestaurantService;
import com.codeoverflow.user.service.repositories.UserRepository;
import com.codeoverflow.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestaurantService restaurantService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // generate unique random id in your project for user id
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        // get all rating service information using rest template...
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // with the help of user repository , get all data from database ...
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Given id resource not found " + userId));

        // fetch the data from RATING SERVICE for the userid user.getUserId()...
        // http://localhost:8083/ratings/users/198142a0-7b18-4462-aec6-08f5cb3f60c0

        Rating[] ratingsOfUser = restTemplate
                .getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);

        logger.info("{}", ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingsList = ratings.stream().map(rating -> {

            Restaurant restaurant = restaurantService.getRestaurant(rating.getRestaurantId());
            // logger.info("response status code: {}", forEntity.getStatusCode());
            rating.setRestaurant(restaurant);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingsList);

        return user;
    }
}
