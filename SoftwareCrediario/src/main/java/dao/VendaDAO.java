package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;


public class VendaDAO {
    private Session session = null;

    public VendaDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Venda findById(Integer id) {
        Venda object = (Venda) session.get(Venda.class, id);
        return object;
    }

    public void save(Venda object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((Venda) object);
        t.commit();
    }

    public void delete(Venda object) {
        Transaction t = session.beginTransaction();
        session.delete((Venda) object);
        t.commit();
    }

    public List<Venda> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);

        Root<Venda> klassRoot = query.from(Venda.class);

        query.select(klassRoot);

        List<Venda> result = session.createQuery(query).getResultList();

        return result;

    }
}
