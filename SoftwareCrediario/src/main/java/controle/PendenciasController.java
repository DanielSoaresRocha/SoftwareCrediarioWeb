
package controle;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

import dao.VendaDAO;
import dao.VendedorDAO;
import modelo.*;
        
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "pendencias")
@SessionScoped
public class PendenciasController {
    private VendaDAO vendaDAO;
    private List<Venda> vendas;
    private Venda vendaAtual;
    
     
    @ManagedProperty(value = "#{login}")
    private LoginController vendedorAtual;
    
    public PendenciasController() {
        System.out.println("ENTROUU EM PENDENCIAS");
        vendaDAO = new VendaDAO();
        vendas = new ArrayList<>();
        vendaAtual = new Venda();
    }
    
    public String realizarCobranca(Venda v){
        vendaAtual = v;
        
        return "/vendedor/cobranca.xhtml";
    }
    
    public String finalizar(){
        vendaDAO = new VendaDAO();
        //System.out.println("valor = "+ vendaAtual.getValorParcelas());
        vendaAtual.setValorPago(vendaAtual.getValorPago() + vendaAtual.getValorParcelas()); //pega o valor enviado e altera o valor pago
        
        vendaDAO.save(vendaAtual);
        
        return "/vendedor/Pendencias.xhtml";
    }
    
    public String editar(Venda v){
        vendaAtual = v;
        
        return "/vendedor/editarVenda.xhtml";
    }
    
    public String salvar(){       
        
        vendaDAO = new VendaDAO();
        vendaDAO.save(vendaAtual);     
        
        return "/vendedor/Pendencias.xhtml";
    }
    
    public void deletar(Venda p){
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor v = vendedorAtual.getVendedorAtual();
        v.getVendas().remove(p); //removendo venda de vendedor
        //v.removeVenda(p);
        vendedorDAO.save(v); //salvando
        System.out.println("REMOVEU DE VENDEDOR");
        
      
        //p.getVendedores().remove(v); //removendo vendedor de venda
        vendaDAO = new VendaDAO();
        p.getCliente().removeVenda(p); //removendo venda de cliente
        
        p.setCliente(null); //removendo cliente de venda
        vendaDAO.save(p);
        System.out.println("TIROU CLIENTE DE VENDA");
        
        
        vendaDAO = new VendaDAO();
        p.getVendedores().remove(p);//removendo vendedor de vendas
        
        vendaDAO.save(p);
        
        vendaDAO = new VendaDAO();
        vendaDAO.delete(p);
        System.out.println("REMOVEU VENDA");
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

    public LoginController getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(LoginController vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
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
