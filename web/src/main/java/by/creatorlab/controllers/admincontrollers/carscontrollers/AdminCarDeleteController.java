package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.services.admin.cars.CarDeleteService;
import by.creatorlab.services.admin.cars.CarShowService;
import by.creatorlab.services.paging.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminCarDeleteController { //this controller doesn't work yet!!!!!!!!!!:(
    @Autowired
    private CarDeleteService carDeleteService;
    @GetMapping("/admin/delete/car/{id}")
    public String deleteCar(Model model, @PathVariable("id") int id) {
        carDeleteService.carDelete(id);
        return "admin/cars/deleteSuccessfully";
    }
}
