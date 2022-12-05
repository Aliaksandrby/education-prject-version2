package by.creatorlab.controllers.usercontrollers;

import by.creatorlab.services.paging.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserCarListShowController {

    @Autowired
    private PagingService pagingService;
    @GetMapping("/user/carList/{currentPage}")
    public String showCarList(Model model, @PathVariable("currentPage") int currentPage) {
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("startPage",pagingService.getStartPage(currentPage));
        model.addAttribute("endPage",pagingService.getEndPage(currentPage));
        model.addAttribute("numberOfPages",pagingService.getNumberOfPages());
        model.addAttribute("carList",pagingService.getCarPaging(currentPage));
        return "user/carList";
    }
}
