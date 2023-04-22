package co.istad.thymeleaf.webapp.controller;


import co.istad.thymeleaf.webapp.model.User;
import co.istad.thymeleaf.webapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private UserService userService;
    private ArticleController articleController;
    @GetMapping("/users")
    String userView(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "/pages/users/user";
    }


    @GetMapping("/userprofile/{userID}")
    public String getProfileById(@PathVariable("userID") int userID ,Model model)
    {
        model.addAttribute("post",articleController.findAllPostByUserId(userID));
        model.addAttribute("users",userService.getSingleUser(userID));
        return "/pages/users/viewUserProfile";
    }

    List<User> getAllUser(){
        return userService.getAllUser();
    }




}
