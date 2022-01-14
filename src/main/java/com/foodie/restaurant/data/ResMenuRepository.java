package com.foodie.restaurant.data;

import com.foodie.restaurant.models.ResMenu;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ResMenuRepository extends CrudRepository<ResMenu, Integer> {


}
