package by.creatorlab.services.admin.cars;

import by.creatorlab.dao.CarDao;
import by.creatorlab.dao.CarDaoImpl;
import by.creatorlab.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDeleteServiceImpl implements CarDeleteService {

    @Autowired
    private CarDao carDao;
    @Override
    public void carDelete(int id) {
        Car car = carDao.findById(id);
        carDao.delete(car);
    }
}
