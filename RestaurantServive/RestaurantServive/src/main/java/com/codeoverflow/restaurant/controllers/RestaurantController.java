package com.codeoverflow.restaurant.controllers;

import com.codeoverflow.restaurant.entities.Restaurant;
import com.codeoverflow.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    //create api here

        @PostMapping
        public ResponseEntity<Restaurant> createRestaurant(@RequestBody  Restaurant restaurant){

           String randomId=  UUID.randomUUID().toString();
           restaurant.setId(randomId);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.create(restaurant));
        }

    //get single item api
    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable String restaurantId){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.get(restaurantId));
    }

    //get all api here
    @GetMapping
        public ResponseEntity<List<Restaurant>> getAll(){

            return ResponseEntity.ok(restaurantService.getAll());
        }
}
