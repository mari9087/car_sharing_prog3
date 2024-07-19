package uni.parthenope.carsharing.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uni.parthenope.carsharing.model.Parcheggio;
import uni.parthenope.carsharing.repository.util.HibernateUtil;

import java.util.List;

public class ParcheggioRepository implements Repository<Parcheggio, Long> {

    @Override
    public List<Parcheggio> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Parcheggio> query = session.createQuery("FROM Parcheggio", Parcheggio.class);
            return query.getResultList();
        }
    }

    @Override
    public Parcheggio getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Parcheggio.class, id);
        }
    }

    @Override
    public Parcheggio save(Parcheggio parcheggio) throws Exception{
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(parcheggio);
            session.getTransaction().commit();
            return parcheggio;
        } catch (Exception e) {
            throw new Exception("Errore durante il salvataggio del parcheggio: " + e.getMessage());
        }
    }

    @Override
    public Parcheggio update(Parcheggio parcheggio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(parcheggio);
            transaction.commit();
            return parcheggio;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Parcheggio parcheggio = session.get(Parcheggio.class, id);
            if (parcheggio != null) {
                session.delete(parcheggio);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }


}
