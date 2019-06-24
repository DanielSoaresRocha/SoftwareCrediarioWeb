package controle;

import dao.ClienteDAO;
import dao.VendedorDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Venda;
import modelo.Vendedor;

@ManagedBean(name = "venda")
@SessionScoped
public class RealizarVendaController {

    private Venda vendaAtual = new Venda();

    @ManagedProperty(value = "#{administrar}")
    private AdministrarClienteController clienteAtual;

    public String realizarVenda() {
        //tentando adicionar venda em vendedor - relaão N pra N
        VendedorDAO daoV = new VendedorDAO();
        FacesContext context = FacesContext.getCurrentInstance();

        ExternalContext ec = context.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(true);
        Vendedor vendedor = (Vendedor) s.getAttribute("vendedor-logado"); // pegando vendedor na sessão
        
        
        vendedor.addVenda(vendaAtual); //adicionando venda
        daoV.save(vendedor); //salvando no banco
        
        //CLIENTE CHEGANDO NULL - SEM FUNCIONAR
        /*
        
        ClienteDAO daoC = new ClienteDAO(); // prepara DAO cliente
        Cliente c = new Cliente();
        c = clienteAtual.getClienteAtual(); //recebe cliente escolhido
        c.addVenda(vendaAtual); //adiciona venda no 1 pra N
        
        daoC.save(c); //salva cliente no banco
        
        */
        
        
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
