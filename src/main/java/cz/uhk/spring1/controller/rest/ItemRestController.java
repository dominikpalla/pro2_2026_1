package cz.uhk.spring1.controller.rest;

import cz.uhk.spring1.model.Item;
import cz.uhk.spring1.service.ItemService;
import cz.uhk.spring1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/items")
public class ItemRestController {

    private ItemService itemService;
    private UserService userService;

    @Autowired
    public ItemRestController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Item> list(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item detail(@PathVariable int id){
        return itemService.getItem(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        itemService.deleteItem(id);
    }

    @PostMapping("/new")
    public void create(@ModelAttribute Item item){
        itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public void update(@ModelAttribute Item item){
        itemService.saveItem(item);
    }

}
