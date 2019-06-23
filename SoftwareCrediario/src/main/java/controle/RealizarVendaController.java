package controle;

import dao.ClienteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import modelo.Cliente;
import modelo.Venda;

@ManagedBean(name="venda")
public class RealizarVendaController {
    private Venda vendaAtual = new Venda();

    @ManagedProperty(value = "#{administrar}")
    private AdministrarClienteController clienteAtual;
    
    
    public String realizarVenda(){
        //vendaAtual = new Venda();
        ClienteDAO c = new ClienteDAO();
        System.out.println("VENDIDO PARA: "+ clienteAtual.getClienteAtual().getId());
        clienteAtual.getClienteAtual().addVenda(vendaAtual);
        
        c.save(clienteAtual.getClienteAtual());
        
        return "/vendedor/Administrar.xhtml";
        
        
    }

    public AdministrarClienteController getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(AdministrarClienteController clienteAtual) {
        this.clienteAtual = clienteAtual;
    }
    
    
    
    public Venda getVendaAtual() {
        return vendaAtual;
    }

    public void setVendaAtual(Venda vendaAtual) {
        this.vendaAtual = vendaAtual;
    }


    
    
}
