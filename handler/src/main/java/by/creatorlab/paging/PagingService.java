package by.creatorlab.paging;

import org.hibernate.SessionFactory;
import java.util.List;

public class PagingService {
    private final int numberOfCarsOnPage = 1;
    private final SessionFactory sessionFactory;
    public PagingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List getCarPaging(int currentPage) {
        return sessionFactory
                .openSession()
                .createQuery("from Car")
                .setFirstResult(numberOfCarsOnPage*(currentPage-1))
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
    public int getNumberOfPages() {
        return (int)Math.ceil(getTotalNumbersOfCars()*1.0/numberOfCarsOnPage);
    }

    public int getStartPage(int currentPage) {
        int startPage;
        if(currentPage < 5) {
            startPage = 1;
        } else {
            if(getNumberOfPages() == currentPage) {
                startPage = currentPage - 4;
            } else {
                startPage = currentPage - 3;
            }
        }
        return startPage;
    }

    public int getEndPage(int currentPage) {
        int endPage;
        if(currentPage < 5) {
            endPage = Math.min(getNumberOfPages(), 5);
        } else {
            if(getNumberOfPages() == currentPage) {
                endPage = currentPage;
            } else {
                endPage = currentPage + 1;
            }
        }
        return endPage;
    }
}
