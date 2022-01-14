package com.foodie.restaurant.Controller;


import com.foodie.restaurant.data.ResMenuRepository;
import com.foodie.restaurant.models.ResMenu;
import org.hibernate.sql.ordering.antlr.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("resmenu")
public class ResMenuController {

    @Autowired
    private ResMenuRepository resMenuRepository;




    @GetMapping
    public String index(Model model) {
        List<ResMenu> data = new ArrayList<>();
        List<ResMenu> appetizer = new ArrayList<>();
        List<ResMenu> kids = new ArrayList<>();
        List<ResMenu> dessert = new ArrayList<>();
        List<ResMenu> soup = new ArrayList<>();
        model.addAttribute("title", "ResMenu");
        Iterable<ResMenu> iterable = resMenuRepository.findAll();
        iterable.forEach(data::add);

        for (ResMenu res1 : data) {

            if (res1.getType().contentEquals("Appetizer")) {
                appetizer.add(res1);
//                System.out.println(res1.getId());
//                System.out.println(res1.getName());
//                System.out.println(res1.getType());
//                System.out.println(res1.getPrice());
            } else if (res1.getType().contentEquals("kidsmenu")) {
                kids.add(res1);
            } else if (res1.getType().contentEquals("soup")) {
                soup.add(res1);
            } else if (res1.getType().contentEquals("dessert")) {
                dessert.add(res1);
            }

            model.addAttribute("appetizer", appetizer);
            model.addAttribute("soup", soup);
            model.addAttribute("dessert", dessert);
            model.addAttribute("kidsmenu", kids);

        }
        return "resmenu/index";
    }

    @GetMapping("add")
    public String addAppetizer(Model model) {
        model.addAttribute("title", "Add ResMenu");
       model.addAttribute("resmenu", new ResMenu());
        return "resmenu/add";
    }

    @PostMapping("add")
    public String processAppetizerForm(@ModelAttribute @Valid ResMenu newresmenu, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "add resmenu");
            return "resmenu/add";
        }
      resMenuRepository.save(newresmenu);
        return "redirect:";
        }


    @GetMapping("delete")
    public String  deleteMenuForm(Model model){
        model.addAttribute("title","Delete");
        model.addAttribute("resmenus",resMenuRepository.findAll());
        return "resmenu/delete";
        }

    @PostMapping("delete")
    public String processDeleteMenuForm(@RequestParam(required=false) int[] menuid){

        if(menuid!=null){
            for( int id:menuid){
                System.out.println(resMenuRepository.findById(id).get().getPrice());
                resMenuRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("update")
    public String updateMenuForm(Model model){
        model.addAttribute("title","Update Menu");
        model.addAttribute("resmenus",resMenuRepository.findAll());
        return "resmenu/update";
    }

    @PostMapping("update")
    public String processUpdateMenuForm(@RequestParam int menuid,Model model){
        model.addAttribute("title","Update Menu");

            model.addAttribute("resmenus", resMenuRepository.findById(menuid));
        System.out.println("updat"+menuid);
            return "/resmenu/updateform";

    }
   @PostMapping("updateform")
  public String processUpdateForm(@RequestParam int menuid,@RequestParam String name,@RequestParam String description,@RequestParam Double price,@RequestParam String type, Model model){
       System.out.println("updateform"+menuid);
   Optional<ResMenu> menuupdate= resMenuRepository.findById(menuid);
   ResMenu res2=menuupdate.get();
   res2.setName(name);
   res2.setDescription(description);
   res2.setPrice(price);
   res2.setType(type);
       System.out.println(res2);
   resMenuRepository.save(res2);

        return "redirect:";
            }



}

