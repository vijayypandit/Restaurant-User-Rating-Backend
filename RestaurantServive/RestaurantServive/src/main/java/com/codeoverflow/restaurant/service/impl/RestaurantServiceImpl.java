package com.codeoverflow.restaurant.service.impl;

import com.codeoverflow.restaurant.entities.Restaurant;
import com.codeoverflow.restaurant.exceptions.ResourceNotFoundException;
import com.codeoverflow.restaurant.repositories.RestaurantRepo;
import com.codeoverflow.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public Restaurant create(Restaurant restaurent) {
        return restaurantRepo.save(restaurent);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant get(String id) {
        return restaurantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resource Found"));
    }
}
