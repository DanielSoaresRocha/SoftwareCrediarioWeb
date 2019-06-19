package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.HibernateUtil;
import modelo.*;

/**
 *
 * @author tanir
 */
public class VendedorDAO {

    private Session session = null;

    public VendedorDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Vendedor findById(Integer id) {
        Vendedor object = (Vendedor) session.get(Vendedor.class, id);
        return object;
    }

    public void save(Vendedor object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((Vendedor) object);
        t.commit();
    }

    public void delete(Vendedor object) {
        Transaction t = session.beginTransaction();
        session.delete((Vendedor) object);
        t.commit();
    }

    public List<Vendedor> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Vendedor> query = builder.createQuery(Vendedor.class);

        Root<Vendedor> klassRoot = query.from(Vendedor.class);

        query.select(klassRoot);

        List<Vendedor> result = session.createQuery(query).getResultList();

        return result;

    }
}
