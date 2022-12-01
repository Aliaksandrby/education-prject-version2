package by.creatorlab.paging;

import by.creatorlab.model.Car;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class PagingService {
    private final SessionFactory sessionFactory;

    public PagingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List getCarPaging(int numberPage, int numberOfCarsOnPage) {
        //Query query = sessionFactory.openSession().createQuery("from Car");
        /*query.setFirstResult(numberPage);
        query.setMaxResults(numberOfCarsOnPage);
        return  query.getResultList();*/

        return sessionFactory
                .openSession()
                .createQuery("from Car")
                .setFirstResult(numberPage)
                .setMaxResults(numberOfCarsOnPage)
                .list();
    }

    public int getTotalNumbersOfCars() {
        //Query countQuery = sessionFactory.openSession().createQuery("from Car");
        //return countQuery.getResultList().size();

        return sessionFactory
                .openSession()
                .createQuery("from Car")
                .list().size();
    }
}
