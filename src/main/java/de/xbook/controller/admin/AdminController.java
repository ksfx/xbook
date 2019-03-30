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
public class AdminController
{
    @RequestMapping("/admin/admin")
    public String users(Model model)
    {
        return "admin/admin";
    }
}
