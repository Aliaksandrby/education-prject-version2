package by.creatorlab.controllers;

import by.creatorlab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserDeleteController {
    @Autowired
    private UserService userService;

    @GetMapping("/index/delete/user/{id}")
    public String deleteUser(Model model, @PathVariable("id") int id) {
        //userService.deleteUser(id);
        return "redirect:/index/users";
    }
}
