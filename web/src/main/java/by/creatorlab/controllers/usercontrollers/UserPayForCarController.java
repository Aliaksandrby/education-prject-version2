package by.creatorlab.controllers.usercontrollers;

import by.creatorlab.dao.CarDaoImpl;
import by.creatorlab.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserPayForCarController {

    @GetMapping("/user/pay/{id}")
    public String payCar(Model model, @PathVariable("id") int id) {
        Car car = new CarDaoImpl().findById(id);
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
