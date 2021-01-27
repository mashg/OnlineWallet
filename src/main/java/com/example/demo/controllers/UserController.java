package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.services.GeneralService;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import javax.validation.Valid;




@Controller
public class UserController {
    private UserService userService;
   // private GeneralService<User> generalService;
    //private ProductToProductForm productToProductForm;

//    @Autowired
//    public void setProductToProductForm(ProductToProductForm productToProductForm) {
//        this.productToProductForm = productToProductForm;
//    }

    @Autowired
    public void setProductService(UserService userService) {
        this.userService = userService;

    }
//    @Autowired
//    public void setProductService(GeneralService<User> generalService) {
//        this.generalService = generalService;
//    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/user/list";
    }

    @RequestMapping({"/user/list", "/user"})
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

}
