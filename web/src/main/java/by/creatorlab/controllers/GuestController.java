package by.creatorlab.controllers;

import by.creatorlab.entities.Car;
import by.creatorlab.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class GuestController {

    @GetMapping("/guest")
    public String showCarList(Model model) {
        List<Car> carList = new CarService().getCarList();
        model.addAttribute("carList",carList);
        return "guest/carList";
    }

    @GetMapping("/guest/{id}")
    public String showCarById(Model model, @PathVariable("id") int id) { //TODO: int redo to Long
        Car car = new CarService().getCarList().get(id-1); //TODO: make findById from Car object

        model.addAttribute("car",car);
        return "guest/car";
    }
}
