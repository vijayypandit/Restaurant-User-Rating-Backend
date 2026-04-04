package com.codeoverflow.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeoverflow.user.service.entities.Restaurant;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantService {

    @GetMapping("/restaurants/{restaurantId}")
    Restaurant getRestaurant(@PathVariable("restaurantId") String restaurantId);

}
