package controle;

import dao.CredencialDAO;
import dao.VendaDAO;
import dao.VendedorDAO;
import genericdao.impl.ClienteDaoImpl;
import genericdao.impl.VendedorDaoImpl;
import genericdao.interfaces.IClienteDao;
import genericdao.interfaces.IVendedorDao;
import java.sql.Date;

import java.util.List;

import modelo.Cliente;
import modelo.Credencial;
import modelo.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.HibernateUtil;
//import modelo.Senha;
import modelo.Vendedor;
import dao.ClienteDAO;

/**
 *
 * @author daniel
 */
public class teste {

    public static void main(String[] args) {
    /*        
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
        c1.setNome("cliente1");
        d.save(c1);
        
        //------------------Adicionando venda no vendedor


        java.util.Date dataUtil = new java.util.Date("28/04/2000");
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        Venda venda = new Venda();
        venda.setNome("venda1");
        venda.setValor(5000.0);
        venda.setValorParcelas(50.0);
        venda.setNumParcelas(30);
        venda.setData(dataSql);
        VendaDAO daoVenda = new VendaDAO();
        daoVenda.save(venda);
      
        c1.addVenda(venda);
        
        v.addVenda(venda);
        daoV.save(v);*/
        //Criando vendedor
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Carlos");
        
        VendedorDAO vendedorDAO = new VendedorDAO();
       // vendedorDAO.save(vendedor);
        
        //Criando venda
        Venda venda = new Venda();
        venda.setNome("NovaVenda");
        
        vendedor.addVenda(venda);
        vendedorDAO.save(vendedor);
        
        //Criando Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Gustavo");
        cliente.addVenda(venda);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.save(cliente);
        
                
        
       
        
    
    }
}
