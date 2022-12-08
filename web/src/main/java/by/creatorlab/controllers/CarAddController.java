package by.creatorlab.controllers;

import by.creatorlab.model.Car;
import by.creatorlab.services.admin.cars.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CarAddController {
    @Autowired
    private CarService carService;
    @GetMapping("/index/add/car")
    public String addCar() {
        return "formForNewCar";
    }
    @PostMapping("/index/add/car")
    public String createCar(Car car, Model model, @RequestParam("images") MultipartFile[] images) throws IOException {
        model.addAttribute("car",carService.addCar(car, images));
        return "showCar";
    }
}
