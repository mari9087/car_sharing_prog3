package uni.parthenope.carsharing.repository;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import uni.parthenope.carsharing.model.Prenotazione;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.util.HibernateUtil;

import java.util.List;

public class PrenotazioneRepository implements Repository<Prenotazione, Long> {

    @Override
    public List<Prenotazione> getAll() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Prenotazione> prenotazioni = session.createQuery("FROM Prenotazione", Prenotazione.class).list();
            return prenotazioni;
        }
    }

    @Override
    public Prenotazione getById(Long id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Prenotazione prenotazione = session.get(Prenotazione.class, id);
            return prenotazione;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Prenotazione prenotazione = session.get(Prenotazione.class, id);
            if (prenotazione != null) {
                session.delete(prenotazione);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    @Transactional
    public Prenotazione update(Prenotazione prenotazione) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(prenotazione);
            session.getTransaction().commit();
            return prenotazione;
        }
    }

    @Override
    @Transactional
    public Prenotazione save(Prenotazione prenotazione) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(prenotazione);
            session.getTransaction().commit();
            return prenotazione;
        }
    }

    public List<Prenotazione> findByUtenteTessera(String tesseraUtente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Prenotazione> query = session.createQuery("FROM Prenotazione WHERE utente.tessera = :tesseraUtente", Prenotazione.class);
            query.setParameter("tesseraUtente", tesseraUtente);
            return query.list();
        }
    }

    public List<Prenotazione> getByUtente(Utente utente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Prenotazione> query = session.createQuery("FROM Prenotazione WHERE utente = :utente", Prenotazione.class);
            query.setParameter("utente", utente);
            return query.getResultList();
        }
    }
}
