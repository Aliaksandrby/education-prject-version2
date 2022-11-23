package by.creatorlab.Dao;

import by.creatorlab.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DaoImpl implements Dao {

    private SessionFactory sessionFactory;


    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void create(Car car) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Car> readAll() {
        try (Session session = sessionFactory.openSession()) {
            String query = "from Car";
            List<Car> carList = session.createQuery(query,Car.class).list();
            return carList;
        }
    }

    @Override
    public void update(Car car) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Car car) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            //session.refresh();
            session.delete(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Car findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Car.class, id);
        }
    }


}
