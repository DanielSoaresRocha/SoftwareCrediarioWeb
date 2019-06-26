package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import persistencia.HibernateUtil;
import modelo.Cliente;
import org.hibernate.Transaction;


public class ClienteDAO {

    private Session session = null;

    public ClienteDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Cliente findById(Integer id) {
        Cliente object = (Cliente) session.get(Cliente.class, id);
         session.close();
        return object;
    }

    public void save(Cliente object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((Cliente) object);
        t.commit();
        session.close();
    }

    public void delete(Cliente object) {
        Transaction t = session.beginTransaction();
        session.delete((Cliente) object);
        t.commit();
         session.close();
    }

    public List<Cliente> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);

        Root<Cliente> klassRoot = query.from(Cliente.class);

        query.select(klassRoot);

        List<Cliente> result = session.createQuery(query).getResultList();
        session.close();
        return result;

    }

}
