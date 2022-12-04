package by.creatorlab.controllers.admincontrollers.usercontrollers;

import by.creatorlab.model.User;
import by.creatorlab.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminUserControllers {
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/userList")
    public String viewUserList(Model model) {
        List<User> userList = new UserService().getUserList();
        model.addAttribute("userList",userList);
        System.out.println("@GetMapping");
        return "admin/users/userList";
    }
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/user/{id}")
    public String viewUser(Model model,@PathVariable("id") int id) {
        User user = new UserService().getUserList().get(id-1);
        model.addAttribute("user",user);
        return "admin/users/user";
    }
    //----------------------------------------------------------------------------------------
    @PostMapping("/admin/edit/user/{id}")
    public String editUser(HttpServletRequest request, Model model, @PathVariable("id") int id) {
        User user = new UserService().getUserList().get(id-1);
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        //user.setRepeatPassword(request.getParameter("repeatPassword"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        model.addAttribute("user",user);
        return "admin/users/user";
    }
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/delete/user/{id}")
    public String deleteUser(Model model, @PathVariable("id") int id) {
        List<User> userList = new UserService().getUserList();
        model.addAttribute("userList",userList);
        return "admin/users/userList";
    }
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/add/user")
    public String addUser() {
        return "admin/users/formForNewUser";
    }
    //----------------------------------------------------------------------------------------
    @PostMapping("/admin/add/user/new")
    public String createUser(HttpServletRequest request,Model model) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        //user.setRepeatPassword(request.getParameter("repeatPassword"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        model.addAttribute("user",user);
        return "admin/users/user";
    }
}
