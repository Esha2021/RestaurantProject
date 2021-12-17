package com.foodie.restaurant.Controller;

import com.foodie.restaurant.data.AppetizerRepository;
import com.foodie.restaurant.models.Appetizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("appetizer")
public class AppetizerController {

@Autowired
    private AppetizerRepository appetizerRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title","Appetizer");
        model.addAttribute("appetizers",appetizerRepository.findAll());
        return "appetizer/index";
    }

    @GetMapping("add")
    public String addAppetizer(Model model){
        model.addAttribute("title","Add Appetizer");
        model.addAttribute("appetizer",new Appetizer());
        return "appetizer/add";
    }

    @PostMapping("add")
    public String  processAppetizerForm(@ModelAttribute @Valid Appetizer newAppetizer, Errors errors, Model model) {

       if (errors.hasErrors())
       {
           model.addAttribute("title","add Appetizer");
           System.out.println(newAppetizer.getName());
           System.out.println(newAppetizer.getDescription());
           System.out.println(newAppetizer.getPrice());
           return "appetizer/add";
        }
      //  model.addAttribute("appetizers","appetizers");
        appetizerRepository.save(newAppetizer);
        model.addAttribute("appetizers",appetizerRepository.findAll());
      return "appetizer/index";
  }
}
