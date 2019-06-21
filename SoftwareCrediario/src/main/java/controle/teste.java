package controle;

import dao.CredencialDAO;
import dao.VendedorDAO;
import genericdao.impl.ClienteDaoImpl;
import genericdao.impl.VendedorDaoImpl;
import genericdao.interfaces.IClienteDao;
import genericdao.interfaces.IVendedorDao;
import java.util.List;

import modelo.Cliente;
import modelo.Credencial;
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
        //Adicionar credencial avendedor         
        VendedorDAO daoV = new VendedorDAO();
        Vendedor v = new Vendedor();
        v.setNome("Daniel Soares Rocha");
        v.setCpf("3452345");
        daoV.save(v);
        
        Credencial c = new Credencial();
        c.setLogin("Daniel");
        c.setSenha("admin");
        c.setVendedor(v);
        
        CredencialDAO daoC = new CredencialDAO();
        daoC.save(c); 
        
        IClienteDao d = new ClienteDaoImpl();
        Cliente c1 = new Cliente();
        c1.setNome("fasdf");
        
        d.save(c1);
        
        
        
    }
}
