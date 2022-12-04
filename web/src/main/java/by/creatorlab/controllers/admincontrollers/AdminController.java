package by.creatorlab.controllers.admincontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin")
    public String mainAdmin() {
        return "admin/main";
    }
    //----------------------------------------------------------------------------------------
}
