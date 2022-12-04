package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.controllers.StaticSessionFactory;
import by.creatorlab.dao.DaoImpl;
import by.creatorlab.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AdminCarShowController {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/car/{id}")
    public String viewCar(Model model, @PathVariable("id") int id) {
        Car car = new DaoImpl(sessionFactory).findById(id);
        model.addAttribute("car",car);
        return "admin/cars/car";
    }
    //----------------------------------------------------------------------------------------
}
