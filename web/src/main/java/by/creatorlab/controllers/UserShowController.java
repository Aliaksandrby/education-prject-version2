package by.creatorlab.controllers;

import by.creatorlab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserShowController {
    @Autowired
    private UserService userService;

    @GetMapping("/index/users")
    public String showUsers(Model model) {
        model.addAttribute("users",userService.getUserList());
        return "showUser";
    }
}
