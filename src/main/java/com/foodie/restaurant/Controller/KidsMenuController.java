package com.foodie.restaurant.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("Kids")
public class KidsMenuController {


    @GetMapping
       public String displayKidsMenu(){

        return "kidsmenu/index";
    }

}
