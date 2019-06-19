package controle;

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

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        
        Vendedor v = new Vendedor();
        v.setNome("Daniel");
        v.setCpf("243243");
        
        Cliente c = new Cliente();
        c.setNome("carlos");
        c.setCpf("31453445");
        c.setEndereco("baixa da égua");
        c.setInformacoes("fkgjsdfogjihdffgjer");
        
        v.addCliente(c);
        sessao.saveOrUpdate((Vendedor) v);
        
        
        transacao.commit();
        
    }
}
