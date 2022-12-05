package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.services.admin.cars.CarAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AdminCarAddController {
    @Autowired
    private CarAddService carAddService;
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/add/car")
    public String addCar() {
        return "admin/cars/formForNewCar";
    }
    //----------------------------------------------------------------------------------------
    @PostMapping("/admin/add/car/new")
    public String createCar(HttpServletRequest request,Model model,
                            @RequestParam("images") MultipartFile[] images) throws IOException {
        model.addAttribute("car",carAddService.addCar(request,images));
        return "admin/cars/car";
    }
    //----------------------------------------------------------------------------------------
}
