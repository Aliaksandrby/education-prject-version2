package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.controllers.StaticSessionFactory;
import by.creatorlab.dao.DaoImpl;
import by.creatorlab.dao.ImageDaoImpl;
import by.creatorlab.model.Car;
import by.creatorlab.model.ImageCar;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

@Controller
public class AdminCarEditController {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
    //----------------------------------------------------------------------------------------
    @PostMapping("/admin/edit/car/{id}")
    public String editCar(
            HttpServletRequest request,
            Model model,
            @PathVariable("id") int id,
            @RequestParam("images") MultipartFile[] images
    ) throws IOException {

        Car car = new DaoImpl(sessionFactory).findById(id);
        car.setName(request.getParameter("name"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setEngineDescription(request.getParameter("engineDescription"));
        car.setTransmission(request.getParameter("transmission"));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        new DaoImpl(sessionFactory).update(car);

        for (ImageCar imageCar : car.getImageList()) new ImageDaoImpl(sessionFactory).delete(imageCar);

        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            new ImageDaoImpl(sessionFactory).create(imageCar);
        }

        car = new DaoImpl(sessionFactory).findById(id);
        model.addAttribute("car",car);
        return "admin/cars/car";
    }
    //----------------------------------------------------------------------------------------
}
