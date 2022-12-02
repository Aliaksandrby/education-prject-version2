package by.creatorlab.paging;

import org.hibernate.SessionFactory;
import java.util.List;

public class PagingService {
    private final SessionFactory sessionFactory;

    public PagingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List getCarPaging(int startCar, int numberOfCarsOnPage) {
        return sessionFactory
                .openSession()
                .createQuery("from Car")
                .setFirstResult(startCar)
                .setMaxResults(numberOfCarsOnPage)
                .list();
    }

    public int getTotalNumbersOfCars() {
        return sessionFactory
                .openSession()
                .createQuery("from Car")
                .list()
                .size();
    }
}
