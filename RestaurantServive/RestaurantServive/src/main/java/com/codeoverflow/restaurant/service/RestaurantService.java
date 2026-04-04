package com.codeoverflow.restaurant.service;

import com.codeoverflow.restaurant.entities.Restaurant;

import java.util.List;

public interface RestaurantService {

    //create
    Restaurant create(Restaurant restaurent);


    //get all details
    List<Restaurant> getAll();

    //get sinle restaurant details
    Restaurant get(String id);

}
