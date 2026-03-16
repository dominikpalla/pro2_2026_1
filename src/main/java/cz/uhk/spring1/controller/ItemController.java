package cz.uhk.spring1.controller;

import cz.uhk.spring1.model.Item;
import cz.uhk.spring1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/")
    public String list(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "items_list";
    }

    @GetMapping("/items/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("item", itemService.getItem(id));
        return "items_detail";
    }

    @GetMapping("/items/{id}/delete")
    public String delete(@PathVariable int id){
        itemService.deleteItem(id);
        return "redirect:/items/";
    }

    @GetMapping("/items/create")
    public String create(Model model){
        model.addAttribute("item", new Item());
        return "items_edit";
    }

    @GetMapping("/items/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Item item = itemService.getItem(id);
        if(item != null){
            model.addAttribute("item", item);
            return "items_edit";
        }else {
            return "redirect:/items/";
        }
    }

    @PostMapping("/items/save")
    public String save(@ModelAttribute Item item){
        itemService.saveItem(item);
        return "redirect:/items/";
    }

}
