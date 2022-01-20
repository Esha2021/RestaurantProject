package com.foodie.restaurant.Controller;

import com.foodie.restaurant.data.UserRepository;
import com.foodie.restaurant.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
 @Autowired
   AuthenticationController authenticationController;
    @GetMapping
    public String homeindex( Model model, HttpServletRequest request){
        User theUser = authenticationController.getUserFromSession(request.getSession());
        model.addAttribute("username",theUser.getUsername());
        return "index";
    }
}
