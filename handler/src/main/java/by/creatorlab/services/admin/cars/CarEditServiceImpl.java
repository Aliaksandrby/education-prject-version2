package by.creatorlab.services.admin.cars;

import by.creatorlab.dao.CarDao;
import by.creatorlab.dao.CarDaoImpl;
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
public class CarEditServiceImpl implements CarEditService {

    @Autowired
    private CarDao carDao;
    @Override
    public Car editCar(HttpServletRequest request, int id, MultipartFile[] images) throws IOException {
        Car car = carDao.findById(id);
        car.setName(request.getParameter("name"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setEngineDescription(request.getParameter("engineDescription"));
        car.setTransmission(request.getParameter("transmission"));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        carDao.update(car);

        for (ImageCar imageCar : car.getImageList()) new ImageDaoImpl().delete(imageCar);

        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            new ImageDaoImpl().create(imageCar);
        }
        return carDao.findById(id);
    }
}
