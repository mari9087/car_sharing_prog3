package uni.parthenope.carsharing.repository;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.util.HibernateUtil;

import java.util.List;

public class UtenteRepository implements Repository<Utente, String> {


    @Override
    public List<Utente> getAll() throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Utente> utentes = session.createQuery("FROM Utente", Utente.class).list();

            return utentes;
        }
    }

    @Override
    public Utente getById(String cf) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Utente utente = session.get(Utente.class, cf);
            return utente;
        }
    }

    @Override
    @Transactional
    public void delete(String tessera) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Utente utente = session.get(Utente.class, tessera);
        }

    }

    @Override
    @Transactional
    public Utente update(Utente utente) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Utente existingUtente = session.get(Utente.class, utente.getTessera());

            if(existingUtente == null){
                throw new RuntimeException("Utente con tessera: " + utente.getTessera() + " non trovato!");
            }

            existingUtente.setNome(utente.getNome());
            existingUtente.setCognome(utente.getCognome());
            existingUtente.setEmail(utente.getEmail());

            session.update(existingUtente);
            session.getTransaction().commit();
            return existingUtente;
        }
    }

    @Override
    @Transactional
    public Utente save(Utente utente) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM Utente WHERE tessera = :tessera");
            query.setParameter("tessera", utente.getTessera());
            List <Utente> existingUtente = query.getResultList();

            if(existingUtente.isEmpty()){
                throw new RuntimeException("Utente con tessera: " + utente.getTessera() + " già esistente!");
            }

            session.beginTransaction();
            session.save(utente);
            session.getTransaction().commit();
            return utente;
        }
    }

    public List<Utente> findLateUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Utente u WHERE u.dataScadenza < current_date";
            Query<Utente> query = session.createQuery(hql, Utente.class);
            return query.list();
        }
    }

    public Utente getByEmailAndPassword(String email, String password) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utente> query = session.createQuery("FROM Utente WHERE email = :email AND password = :password", Utente.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Utente> result = query.getResultList();
            if (result.isEmpty()) {
                throw new RuntimeException("Utente non trovato per email e password fornite.");
            }
            return result.get(0);
        }
    }
}
