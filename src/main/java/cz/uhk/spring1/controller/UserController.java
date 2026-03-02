package cz.uhk.spring1.controller;

import cz.uhk.spring1.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UserController {

    private ArrayList<User> users = new ArrayList<>();

    public UserController(){
        User user = new User();
        user.setId(1);
        user.setName("Karel");
        users.add(user);
    }

    @GetMapping("/users/")
    public String list(Model model){
        model.addAttribute("users", users);
        return "users_list";
    }

    @GetMapping("/users/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("user", findUserById(id));
        return "users_detail";
    }

    @GetMapping("/users/{id}/delete")
    public String delete(@PathVariable int id){
        User user = findUserById(id);
        if(user != null){
            users.remove(user);
        }
        return "redirect:/users/";
    }

    @GetMapping("/users/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users_edit";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        User user = findUserById(id);
        if(user != null){
            model.addAttribute("user", user);
            return "users_edit";
        }else {
            return "redirect:/users/";
        }
    }

    @PostMapping("/users/save")
    public String save(@ModelAttribute User user){
        if(user != null){
            if(user.getId() == 0){
                int id = 1;
                if(!users.isEmpty()){
                    id = users.get(users.size()-1).getId()+1;
                }
                user.setId(id);
                users.add(user);
            }else{
                User u = findUserById(user.getId());
                if(u != null){
                    u.setName(user.getName());
                    u.setPassword(user.getPassword());
                }
            }
        }
        return "redirect:/users/";
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
