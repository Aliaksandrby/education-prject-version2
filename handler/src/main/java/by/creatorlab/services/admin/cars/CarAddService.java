package by.creatorlab.services.admin.cars;

import by.creatorlab.model.Car;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface CarAddService {
    Car addCar(HttpServletRequest request, MultipartFile[] images)throws IOException;
}
