package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.services.admin.cars.CarEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AdminCarEditController {
    @Autowired
    private CarEditService carEditService;
    //----------------------------------------------------------------------------------------
    @PostMapping("/admin/edit/car/{id}")
    public String editCar(HttpServletRequest request,Model model,@PathVariable("id") int id,
            @RequestParam("images") MultipartFile[] images) throws IOException {
        model.addAttribute("car",carEditService.editCar(request,id,images));
        return "admin/cars/car";
    }
    //----------------------------------------------------------------------------------------
}
