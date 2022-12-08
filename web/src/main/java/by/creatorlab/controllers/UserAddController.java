package by.creatorlab.controllers;

import by.creatorlab.model.User;
import by.creatorlab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAddController {

    @Autowired
    private UserService userService;

    @GetMapping("/index/user/add")
    public String addUser() {
        return "formForNewUser";
    }

    @PostMapping("/index/user/add")
    public String createUser(User user, Model model) {
        //TODO: do something
        return "redirect:/index/users";
    }
}
