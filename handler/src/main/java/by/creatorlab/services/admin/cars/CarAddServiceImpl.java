package by.creatorlab.services.admin.cars;

import by.creatorlab.dao.CarDao;
import by.creatorlab.dao.ImageDaoImpl;
import by.creatorlab.model.Car;
import by.creatorlab.model.ImageCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

@Service
public class CarAddServiceImpl implements CarAddService {
    @Autowired
    private CarDao carDao;
    @Override
    public Car addCar(HttpServletRequest request, MultipartFile[] images) throws IOException {
        Car car = new Car();
        car.setName(request.getParameter("name"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setEngineDescription(request.getParameter("engineDescription"));
        car.setTransmission(request.getParameter("transmission"));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        carDao.create(car);
        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            new ImageDaoImpl().create(imageCar);
        }
        return carDao.findById(car.getId());
    }
}
