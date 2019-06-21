package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Credencial;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

/**
 *
 * @author Aluno
 */
public class CredencialDAO {
    
    private Session session = null;

    public CredencialDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Credencial findById(Integer id) {
        Credencial object = (Credencial) session.get(Credencial.class, id);
        return object;
    }

    public void save(Credencial object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((Credencial) object);
        t.commit();
    }

    public void delete(Credencial object) {
        Transaction t = session.beginTransaction();
        session.delete((Credencial) object);
        t.commit();
    }

    public List<Credencial> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Credencial> query = builder.createQuery(Credencial.class);

        Root<Credencial> klassRoot = query.from(Credencial.class);

        query.select(klassRoot);

        List<Credencial> result = session.createQuery(query).getResultList();

        return result;

    }
}
