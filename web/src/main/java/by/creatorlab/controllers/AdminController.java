package by.creatorlab.controllers;

import by.creatorlab.entities.Car;
import by.creatorlab.entities.Order;
import by.creatorlab.entities.Payment;
import by.creatorlab.entities.User;
import by.creatorlab.services.CarService;
import by.creatorlab.services.OrderService;
import by.creatorlab.services.PaymentService;
import by.creatorlab.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

//----------------------------------------------------------------------------------------
    @GetMapping("/admin")
    public String mainAdmin() {
        System.out.println("@GetMapping");//
        return "admin/admin";
    }
//----------------------------------------------------------------------------------------
    @GetMapping("/admin/carList")
    public String viewCarList(Model model) {
        List<Car> carList = new CarService().getCarList();
        model.addAttribute("carList",carList);
        System.out.println("@GetMapping");//
        return "admin/cars/carList";
    }

    @GetMapping("/admin/car/{id}")
    public String viewCar(Model model, @PathVariable("id") int id) { // int to Long
        Car car = new CarService().getCarList().get(id-1);

        model.addAttribute("car",car);
        System.out.println("@GetMapping");//
        return "admin/cars/car";
    }

    @PostMapping("/admin/edit/car/{id}")
    public String editCar(HttpServletRequest request,Model model, @PathVariable("id") int id) { // int to Long
        Car car = new CarService().getCarList().get(id-1);
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String engineDescription = request.getParameter("engineDescription");
        String transmission = request.getParameter("transmission");
        int price = Integer.parseInt(request.getParameter("price"));
        String pathToImage = request.getParameter("pathToImage");

        /*car.setName(name);
        car.setYear(year);
        car.setEngineDescription(engineDescription);
        car.setTransmission(transmission);
        car.setPrice(price);
        car.setPathToImageList(List.of(pathToImage));*/

        System.out.println(car);

        model.addAttribute("car",car);
        System.out.println("EDIT SUCCESS!!!!!!!!!! @PostMapping"); //
        return "admin/cars/car";
    }

    @GetMapping("/admin/delete/car/{id}")
    public String deleteCar(Model model, @PathVariable("id") int id) {
        List<Car> carList = new CarService().getCarList();
        //Car car = new CarService().getCarList().get(id-1);

        model.addAttribute("carList",carList);
        System.out.println("DELETE SUCCESS!!!!!! @GetMapping");//
        return "admin/cars/carList";
    }

    @GetMapping("/admin/add/car")
    public String addCar() {
        System.out.println("@GetMapping");//
        return "admin/cars/formForNewCar";
    }

    @PostMapping("/admin/add/car/new")
    public String createCar(HttpServletRequest request,Model model) {

        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String engineDescription = request.getParameter("engineDescription");
        String transmission = request.getParameter("transmission");
        int price = Integer.parseInt(request.getParameter("price"));
        String pathToImage = request.getParameter("pathToImage");

        Car car = new Car();
        //car.setId(25L); //
        car.setName(name);
        car.setYear(year);
        car.setEngineDescription(engineDescription);
        car.setTransmission(transmission);
        car.setPrice(price);
        car.setPathToImageList(List.of(pathToImage));

        System.out.println(car.getId());
        System.out.println(car.getName());
        System.out.println(car.getYear());
        System.out.println(car.getEngineDescription());
        System.out.println(car.getTransmission());
        System.out.println(car.getPrice());
        System.out.println(car.getPathToImageList().get(0));


        model.addAttribute("car",car);

        System.out.println("@PostMapping"); //
        return "admin/cars/car";
    }

    //Todo: search cars
//----------------------------------------------------------------------------------------
    @GetMapping("/admin/userList")
    public String viewUserList(Model model) {
        List<User> userList = new UserService().getUserList();
        model.addAttribute("userList",userList);
        System.out.println("@GetMapping");
        return "admin/users/userList";
    }

    @GetMapping("/admin/user/{id}")
    public String viewUser(Model model,@PathVariable("id") int id) { //int to Long
        User user = new UserService().getUserList().get(id-1);
        model.addAttribute("user",user);
        System.out.println("@GetMapping");
        return "admin/users/user";
    }

    @PostMapping("/admin/edit/user/{id}")
    public String editUser(HttpServletRequest request,Model model, @PathVariable("id") int id) { // int to Long
        User user = new UserService().getUserList().get(id-1);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatPassword =request.getParameter("repeatPassword"); // Todo:
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        user.setUsername(username);
        user.setPassword(password);
        //user.setRepeatPassword(password);
        user.setEmail(email);
        user.setPhone(phone);


        System.out.println(user);

        model.addAttribute("user",user);
        System.out.println("EDIT SUCCESS!!!!!!!!!! @PostMapping"); //
        return "admin/users/user";
    }

    @GetMapping("/admin/delete/user/{id}")
    public String deleteUser(Model model, @PathVariable("id") int id) {
        List<User> userList = new UserService().getUserList();
        //User user = new UserService().getUserList().get(id-1);

        model.addAttribute("userList",userList);
        System.out.println("DELETE SUCCESS!!!!!! @GetMapping");//
        return "admin/users/userList";
    }

    @GetMapping("/admin/add/user")
    public String addUser() {
        System.out.println("@GetMapping");//
        return "admin/users/formForNewUser";
    }

    @PostMapping("/admin/add/user/new")
    public String createUser(HttpServletRequest request,Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatPassword =request.getParameter("repeatPassword"); // Todo:
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //user.setRepeatPassword(password);
        user.setEmail(email);
        user.setPhone(phone);


        System.out.println(user);

        model.addAttribute("user",user);
        System.out.println("@PostMapping"); //

        return "admin/users/user";
    }

    //Todo: search users
//----------------------------------------------------------------------------------------
    @GetMapping("/admin/orderList")
    public String showOrderList(Model model) {
        List<Order> orderList = new OrderService().getOrderList();
        model.addAttribute("orderList",orderList);
        return "admin/orders/orderList";
    }
//----------------------------------------------------------------------------------------
    @GetMapping("/admin/paymentList")
    public String showPaymentList(Model model) {
        List<Payment> paymentList = new PaymentService().getPaymentList();
        model.addAttribute("paymentList",paymentList);
        return "admin/payments/paymentList";
    }
}
