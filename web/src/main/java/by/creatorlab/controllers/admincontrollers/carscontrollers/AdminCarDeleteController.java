package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.services.admin.cars.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminCarDeleteController { //this controller doesn't work yet!!!!!!!!!!:(
    @Autowired
    private CarService carService;
    @GetMapping("/admin/delete/car/{id}")
    public String deleteCar(Model model, @PathVariable("id") int id) {
        carService.deleteCar(id);
        return "admin/cars/deleteSuccessfully";
    }
}
