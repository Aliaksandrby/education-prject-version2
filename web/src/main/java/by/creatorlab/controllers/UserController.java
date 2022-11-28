package by.creatorlab.controllers;

import by.creatorlab.configuration.DataConfig;
import by.creatorlab.configuration.MysqlSessionFactory;
import by.creatorlab.dao.DaoImpl;
import by.creatorlab.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private List<Car> carList;
    private Car car;
    private SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES,DataConfig.HIBERNATE_PROPERTIES);

    @GetMapping("/user")
    public String showCarList(Model model) {
        carList = new DaoImpl(sessionFactory).readAll();
        model.addAttribute("carList",carList);
        return "user/carList";
    }

    @GetMapping("/user/{id}")
    public String showCarById(Model model, @PathVariable("id") int id) { //TODO: int redo to Long
        car = new DaoImpl(sessionFactory).findById(id);

        model.addAttribute("car",car);
        return "user/car";
    }

    @GetMapping("/user/pay/{id}")
    public String payCar(Model model, @PathVariable("id") int id) { //TODO: int redo to Long
        car = new DaoImpl(sessionFactory).findById(id);

        model.addAttribute("car",car);
        return "user/formPayCar";
    }

    @PostMapping("/user/pay/made")
    public String payCarSuccess(HttpServletRequest request) {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);

        return "user/successPay";
    }
}
