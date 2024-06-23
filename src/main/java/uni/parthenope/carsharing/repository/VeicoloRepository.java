package uni.parthenope.carsharing.repository;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import uni.parthenope.carsharing.model.Veicolo;
import uni.parthenope.carsharing.repository.util.HibernateUtil;

import java.util.List;

public class VeicoloRepository implements Repository <Veicolo, Long> {

    @Override
    public List<Veicolo> getAll() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Veicolo> veicoli = session.createQuery("FROM Veicolo ", Veicolo.class).list();

            return veicoli;
        }
    }

    @Override
    public Veicolo getById(Long id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Veicolo cars = session.get(Veicolo.class, id);

            return cars;
        }
    }

    @Override
    @Transactional
    public Veicolo save(Veicolo veicolo) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(veicolo);
            session.getTransaction().commit();
            return veicolo;
        }
    }

    @Override
    @Transactional
    public Veicolo update(Veicolo veicolo) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(veicolo);
            session.getTransaction().commit();
            return veicolo;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Veicolo cars = session.get(Veicolo.class, id);

            if (cars == null)
                throw new RuntimeException("Campo con numero " + id + " non trovato");

            session.delete(cars);
            session.getTransaction().commit();
        }
    }

    public Veicolo getByTarga(String targa) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Veicolo> query = session.createQuery("FROM Veicolo WHERE targa = :targa", Veicolo.class);
            query.setParameter("targa", targa);
            List<Veicolo> result = query.getResultList();
            if (result.isEmpty()) {
                throw new RuntimeException("Veicolo non trovato per targa: " + targa);
            }
            return result.get(0);
        }
    }
}
