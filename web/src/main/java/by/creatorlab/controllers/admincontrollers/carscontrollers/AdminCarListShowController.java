package by.creatorlab.controllers.admincontrollers.carscontrollers;

import by.creatorlab.controllers.StaticSessionFactory;
import by.creatorlab.paging.PagingService;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminCarListShowController {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
    //----------------------------------------------------------------------------------------
    @GetMapping("/admin/carList/{currentPage}")
    public String viewCarList(Model model, @PathVariable("currentPage") int currentPage) {
        PagingService pagingService = new PagingService(sessionFactory);

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("startPage",pagingService.getStartPage(currentPage));
        model.addAttribute("endPage",pagingService.getEndPage(currentPage));
        model.addAttribute("numberOfPages",pagingService.getNumberOfPages());
        model.addAttribute("carList",pagingService.getCarPaging(currentPage));
        return "admin/cars/carList";
    }
    //----------------------------------------------------------------------------------------
}
