package by.creatorlab.paging;

import by.creatorlab.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import java.util.List;

public class PagingService {
    private final SessionFactory sessionFactory;

    public PagingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Car> getCarPaging(int firstResult, int pageSize) {
        Query query = sessionFactory.openSession().createQuery("From Car");
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        return  query.getResultList();
    }

    public Integer getTotalPage() {
        Criteria criteriaCount = sessionFactory.openSession().createCriteria(Car.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Integer) criteriaCount.uniqueResult();
    }
}
