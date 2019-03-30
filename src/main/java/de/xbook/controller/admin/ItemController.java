package de.xbook.controller.admin;

import de.xbook.dao.item.ItemDAO;
import de.xbook.dao.user.UserDAO;
import de.xbook.model.item.Item;
import de.xbook.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ItemController
{
    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping("/admin/items")
    public String items(Model model)
    {
        model.addAttribute("allItems", itemDAO.getAllItems());

        return "admin/item/items";
    }


    @RequestMapping(path = "/admin/items/add", method = RequestMethod.GET)
    public String add(Model model)
    {
        model.addAttribute("item", new Item());

        return "admin/item/edit";
    }

    @RequestMapping("/admin/items/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("item", itemDAO.getItem(id));

        return "admin/item/edit";
    }

    @RequestMapping(value = "/admin/items/save", method = RequestMethod.POST)
    public String submit(Item item, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println("Form has errors...");
        }

        System.out.println("Id 111: " + item.getId());
        System.out.println("Item Title: " + item.getTitle());

        itemDAO.save(item);

        return "redirect:/admin/items";
    }
}
