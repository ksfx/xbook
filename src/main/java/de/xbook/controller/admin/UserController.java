package de.xbook.controller.admin;

import de.xbook.dao.user.UserDAO;
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
public class UserController
{
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/admin/users")
    public String users(Model model)
    {
        model.addAttribute("allUsers", userDAO.getAllUsers());

        return "admin/user/users";
    }

    @RequestMapping("/admin/users/edit/{id}")
    public String users(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("user", userDAO.getUser(id));

        return "admin/user/edit";
    }

    @RequestMapping(value = "/admin/users/edit/{id}", method = RequestMethod.POST)
    public String loginPage(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id)
    {
        if (bindingResult.hasErrors()) {
            System.out.println("Form has errors...");
        }

        System.out.println("Id 111: " + id);
        System.out.println("Id: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Enabled: " + user.isEnabled());

        return "admin/user/edit";
    }
}
