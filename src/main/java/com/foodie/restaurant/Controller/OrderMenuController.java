package com.foodie.restaurant.Controller;

import com.foodie.restaurant.data.CartRepository;
import com.foodie.restaurant.data.ResMenuRepository;
import com.foodie.restaurant.models.Cart;
import com.foodie.restaurant.models.ResMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("order")
public class OrderMenuController {

    @Autowired
    private ResMenuRepository resMenuRepository;

       @Autowired
    private CartRepository cartRepository;
    List<ResMenu> myorder= new ArrayList<>();

    public void claerArrayList(){
        myorder.clear();
    }

    @GetMapping
    public String index(Model model) {
        List<ResMenu> data = new ArrayList<>();
        List<ResMenu> appetizer = new ArrayList<>();
        List<ResMenu> kids = new ArrayList<>();
        List<ResMenu> dessert = new ArrayList<>();
        List<ResMenu> soup = new ArrayList<>();

        model.addAttribute("title", "OrderMenu");
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
        //model.addAttribute(orderMenuRepository.findAll());

        return "order/index";
    }


    @PostMapping()
    public String OrderMenuForm(@RequestParam(required = false) int[] menuid, Model model) {
//List<ResMenu> myorder= new ArrayList<>();
//     {


                if (menuid != null) {
                    for (int id : menuid) {
                        resMenuRepository.findById(id);
                        Optional<ResMenu> myorderlist = resMenuRepository.findById(id);
                        myorder.add(myorderlist.get());
                    }
                }


        model.addAttribute("myorder",myorder);
            return "order/myorder";
        }




    @PostMapping ("myorder")
    public String ProcessOrderMenuBillForm(@RequestParam(required = false) int[] menuid,@RequestParam(required = false) int[] itemcount, Model model) {
// double total=0;
// Cart[] newcart= new Cart[itemcount.length];
//        for (int i = 0; i < itemcount.length; i++) {
//            double amount1 = resMenuRepository.findById(menuid[i]).get().getPrice() * itemcount[i];
//            newcart[i].setMenuid(menuid[i]);
//            newcart[i].setName(resMenuRepository.findById(menuid[i]).get().getName());
//            newcart[menuid[i]].setPrice(resMenuRepository.findById(menuid[i]).get().getPrice());
//            newcart[menuid[i]].setItemcount(itemcount[i]);
//            newcart[menuid[i]].setAmount(amount1);
//            cartRepository.save(newcart[menuid[i]]);
//            total = total + amount1;
//        }
//        model.addAttribute("cartitems",cartRepository.findAll());
//        model.addAttribute("total",total);
        List<Cart> cartitems= new ArrayList<>();
        double total=0;

        for (int i = 0; i < itemcount.length; i++) {
            double amount1 = resMenuRepository.findById(menuid[i]).get().getPrice() * itemcount[i];
          Cart cartitem = new Cart( menuid[i],
                          resMenuRepository.findById(menuid[i]).get().getName(),
                          resMenuRepository.findById(menuid[i]).get().getPrice(),itemcount[i],amount1);
           cartitems.add(cartitem);

             total=total+amount1;
        }

      model.addAttribute("cartitems", cartitems);
       model.addAttribute("total",total);
     return "order/orderbill";
    }

 }
//










