package com.foodie.restaurant.data;

import com.foodie.restaurant.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends CrudRepository<Cart,Integer> {

}
