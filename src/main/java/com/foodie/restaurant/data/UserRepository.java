package com.foodie.restaurant.data;

import com.foodie.restaurant.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
