package by.creatorlab.services.admin.cars;

import by.creatorlab.model.Car;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface CarService {
    Car addCar(Car car, MultipartFile[] images)throws IOException;
    void deleteCar(int id);
    Car editCar(HttpServletRequest request, int id, MultipartFile[] images) throws IOException;
}
