package controle;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.HibernateUtil;
import modelo.Senha;
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
        v.setCpf(1235144);
        
        Senha s = new Senha();
        s.setSenha("daniel123");
        
        v.setSenha(s);
        s.setVendedor(v);
        
        sessao.save(s);
        
        transacao.commit();
        
    }
}
