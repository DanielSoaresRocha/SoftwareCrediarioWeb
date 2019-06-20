package controle;

import dao.VendedorDAO;
import genericdao.impl.VendedorDaoImpl;
import genericdao.interfaces.IVendedorDao;
import java.util.List;

import modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.HibernateUtil;
//import modelo.Senha;
import modelo.Vendedor;
/**
 *
 * @author daniel
 */
public class teste {
    
    public static void main(String[] args) {
          
       VendedorDAO dao = new VendedorDAO();
        
       Vendedor v = new Vendedor("cpf","nome", "senha");
       Vendedor v2 = new Vendedor("cpff","nogme", "segnha");
       Vendedor v3 = new Vendedor("cpgf","nofme", "sefnha");
       
       dao.save(v);
       dao.save(v2);
       dao.save(v3);
       
       List<Vendedor> vendedores = dao.listAll();
       
       for (Vendedor i : vendedores) {
            System.out.println(i.getNome());  
        }
       
       
        
        
        
    }
}
