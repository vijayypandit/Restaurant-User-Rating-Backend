package com.codeoverflow.restaurant.repositories;

import com.codeoverflow.restaurant.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,String> {



}
