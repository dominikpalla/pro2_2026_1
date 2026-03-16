package cz.uhk.spring1.controller;

import cz.uhk.spring1.model.User;
import cz.uhk.spring1.service.UserService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/")
    public String list(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    @GetMapping("/users/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("userDTO", userService.getUserDTO("me@me.com"));
        return "users_detail";
    }

    @GetMapping("/users/{id}/delete")
    public String delete(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @GetMapping("/users/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users_edit";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        User user = userService.getUser(id);
        if(user != null){
            model.addAttribute("user", user);
            return "users_edit";
        }else {
            return "redirect:/users/";
        }
    }

    @PostMapping("/users/save")
    public String save(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/";
    }

}
