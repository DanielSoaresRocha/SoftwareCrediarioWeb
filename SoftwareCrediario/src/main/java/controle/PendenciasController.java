
package controle;

import java.util.ArrayList;
import java.util.List;

import dao.VendaDAO;
import modelo.Venda;
        
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "pendencias")
@SessionScoped
public class PendenciasController {
    private VendaDAO vendaDAO;
    private List<Venda> vendas;
    private Venda vendaAtual;
    
    public PendenciasController() {
        vendaDAO = new VendaDAO();
        vendas = new ArrayList<>();
        vendaAtual = new Venda();
    }
    
    public String editar(Venda v){
        vendaAtual = v;
        
        return "/vendedor/editarVenda.xhtml";
    }
    
    public void deletar(Venda c){
        vendaDAO = new VendaDAO();
        vendaDAO.delete(c);
    }

    public void listar(){
        vendaDAO = new VendaDAO();
        vendas = new ArrayList<>();
        
        vendas = vendaDAO.listAll();
        
    }
    
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    
    
    public VendaDAO getVendaDAO() {
        return vendaDAO;
    }

    public void setVendaDAO(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    public Venda getVendaAtual() {
        return vendaAtual;
    }

    public void setVendaAtual(Venda vendaAtual) {
        this.vendaAtual = vendaAtual;
    }

    
    
    
}
