package by.creatorlab.controllers.guestcontrollers;

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
public class GuestController {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
    @GetMapping("/guest")
    public String showCarList(Model model) {
        List<Car> carList = new DaoImpl(sessionFactory).readAll();
        model.addAttribute("carList",carList);
        return "guest/carList";
    }

    @GetMapping("/guest/{id}")
    public String showCarById(Model model, @PathVariable("id") int id) {
        Car car = new DaoImpl(sessionFactory).findById(id);
        model.addAttribute("car",car);
        return "guest/car";
    }
}
