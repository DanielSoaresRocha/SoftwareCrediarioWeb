package controle;

import dao.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;
import modelo.*;

public class teste2 {
    public static void main(String[] args) {
    Cliente c= new Cliente();
    c.setNome("calors");
    c.setTelefone(43);
    
    ClienteDAO dao = new ClienteDAO();
    dao.save(c);
    
    dao.delete(c);
    }
}
