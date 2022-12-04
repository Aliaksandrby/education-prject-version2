package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.controllers.StaticSessionFactory;
import by.creatorlab.dao.DaoImpl;
import by.creatorlab.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminCarDeleteController {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/delete/car/{id}")
    public String deleteCar(Model model, @PathVariable("id") int id) {
        Car car = new DaoImpl(sessionFactory).findById(id);
        new DaoImpl(sessionFactory).delete(car);
        List<Car> carList = new DaoImpl(sessionFactory).readAll();
        model.addAttribute("carList",carList);
        return "admin/cars/carList";
    }
    //----------------------------------------------------------------------------------------
}
