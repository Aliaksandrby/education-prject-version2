package by.creatorlab.controllers;

import by.creatorlab.dao.DaoImpl;
import by.creatorlab.configuration.DataConfig;
import by.creatorlab.configuration.MysqlSessionFactory;
import by.creatorlab.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class GuestController {

    private List<Car> carList;
    private Car car;
    private final SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES,DataConfig.HIBERNATE_PROPERTIES);

    @GetMapping("/guest")
    public String showCarList(Model model) {
        carList = new DaoImpl(sessionFactory).readAll();
        model.addAttribute("carList",carList);
        return "guest/carList";
    }

    @GetMapping("/guest/{id}")
    public String showCarById(Model model, @PathVariable("id") int id) {
        car = new DaoImpl(sessionFactory).findById(id);

        System.out.println(car);


        model.addAttribute("car",car);
        return "guest/car";
    }
}
