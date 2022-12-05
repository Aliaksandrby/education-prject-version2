package by.creatorlab.controllers.guestcontrollers;

import by.creatorlab.services.showServices.CarShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GuestCarShowController {
    @Autowired
    private CarShowService carShowService;
    @GetMapping("/guest/car/{id}")
    public String showCarById(Model model, @PathVariable("id") int id) {
        model.addAttribute("car",carShowService.getCar(id));
        return "guest/car";
    }
}
