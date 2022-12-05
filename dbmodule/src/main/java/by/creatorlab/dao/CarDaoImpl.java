package by.creatorlab.dao;

import by.creatorlab.model.Car;
import by.creatorlab.sessionfactory.StaticSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private static final SessionFactory sessionFactory = StaticSessionFactory.getInstance();
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
            return session.createQuery(query,Car.class).list();
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
