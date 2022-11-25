package by.creatorlab.controllers;

import by.creatorlab.Dao.DaoImpl;
import by.creatorlab.Dao.ImageDao;
import by.creatorlab.Dao.ImageDaoImpl;
import by.creatorlab.config.DataConfig;
import by.creatorlab.config.MysqlSessionFactory;
import by.creatorlab.entities.*;
import by.creatorlab.services.OrderService;
import by.creatorlab.services.PaymentService;
import by.creatorlab.services.UserService;
//import org.apache.commons.codec.base64.Base64;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Base64;
import java.util.List;

@Controller
public class AdminController {

    private List<Car> carList;
    private Car car;
    private SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES,DataConfig.HIBERNATE_PROPERTIES);

//----------------------------------------------------------------------------------------
    @GetMapping("/admin")
    public String mainAdmin() {
        System.out.println("@GetMapping");//
        return "admin/admin";
    }
//----------------------------------------------------------------------------------------
    @GetMapping("/admin/carList")
    public String viewCarList(Model model) {
        carList = new DaoImpl(sessionFactory).readAll();
        model.addAttribute("carList",carList);
        System.out.println("@GetMapping");//
        return "admin/cars/carList";
    }

    @GetMapping("/admin/car/{id}")
    public String viewCar(Model model, @PathVariable("id") int id) {
        car = new DaoImpl(sessionFactory).findById(id);

        model.addAttribute("car",car);
        System.out.println("@GetMapping");//
        return "admin/cars/car";
    }

    @PostMapping("/admin/edit/car/{id}")
    public String editCar(HttpServletRequest request,Model model, @PathVariable("id") int id) {
        car = new DaoImpl(sessionFactory).findById(id);

        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String engineDescription = request.getParameter("engineDescription");
        String transmission = request.getParameter("transmission");
        int price = Integer.parseInt(request.getParameter("price"));
        String[] pathToImage = request.getParameterValues("pathToImage");

        car.setName(name);
        car.setYear(year);
        car.setEngineDescription(engineDescription);
        car.setTransmission(transmission);
        car.setPrice(price);
        //car.setPathToImageList(List.of(pathToImage));//do something with foto car
        for (String str : pathToImage) {
            System.out.println(pathToImage);
        }


        new DaoImpl(sessionFactory).update(car);

        model.addAttribute("car",car);
        System.out.println("EDIT SUCCESS!!!!!!!!!! @PostMapping"); //
        return "admin/cars/car";
    }

    @GetMapping("/admin/delete/car/{id}")
    public String deleteCar(Model model, @PathVariable("id") int id) {
        car = new DaoImpl(sessionFactory).findById(id);
        System.out.println(car);
        new DaoImpl(sessionFactory).delete(car);

        carList = new DaoImpl(sessionFactory).readAll();

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
    public String createCar(HttpServletRequest request, Model model, @RequestParam("images") MultipartFile images) throws IOException {

        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String engineDescription = request.getParameter("engineDescription");
        String transmission = request.getParameter("transmission");
        int price = Integer.parseInt(request.getParameter("price"));

        Car car = new Car();
        car.setName(name);
        car.setYear(year);
        car.setEngineDescription(engineDescription);
        car.setTransmission(transmission);
        car.setPrice(price);

        new DaoImpl(sessionFactory).create(car);

        String img = "/img/";
        String backUp = request.getSession().getServletContext().getRealPath(img);
        System.out.println(backUp);

        /*ImageCar imageCar = new ImageCar();
        imageCar.setCar(car);
        imageCar.setImage("");
        new ImageDaoImpl(sessionFactory).create(imageCar);*/

        /*String img = "/img/";
        String realPathtoUploads =
                request.getSession().getServletContext().getRealPath(uploadsDir);
        if(! new File(realPathtoUploads).exists()) {
            new File(realPathtoUploads).mkdir();
        }
        String orgName = images.getOriginalFilename();
        String filePath = realPathtoUploads + orgName;
        File dest = new File(filePath);
        System.out.println(dest);
        images.transferTo(dest);*/

        /*System.out.println(this.getClass().getClassLoader().getResource("static"));
        String storeImage = System.getProperty("user.dir") + "/img/cars/" + car.getId();
        new File(storeImage).mkdir();
        for ( MultipartFile image : images) {
            Path fileNameAndPath = Paths.get(storeImage, image.getOriginalFilename());
            Files.write(fileNameAndPath, image.getBytes());
            String pathName = storeImage + "/" + image.getOriginalFilename();
            System.out.println(pathName);
            ImageCar imageCar = new ImageCar();
            imageCar.setPathImage(pathName);
            imageCar.setCar(car);
            new ImageDaoImpl(sessionFactory).create(imageCar);
        }*/

        Car newCar =  new DaoImpl(sessionFactory).findById(car.getId());
        model.addAttribute("car",newCar);
        System.out.println("@PostMapping add car"); //
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
