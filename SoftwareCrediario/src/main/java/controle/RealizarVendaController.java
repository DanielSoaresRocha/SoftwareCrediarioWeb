package controle;

import dao.ClienteDAO;
import dao.VendaDAO;
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

    private Venda vendaAtual;
    
    @ManagedProperty(value = "#{login}")
    private LoginController vendedorAtual;

    @ManagedProperty(value = "#{administrar}")
    private AdministrarClienteController clienteAtual;

    public RealizarVendaController() {
        System.out.println("ENTROU DE PRIMEIRRRRAAA");
        vendaAtual = new Venda();
    }

    public String realizarVenda() {
        //tentando adicionar venda em vendedor - relação N pra N
        System.out.println("Id venda = " + vendaAtual.getId() + "Nome = " + vendaAtual.getNome());
        Vendedor vendedor = vendedorAtual.getVendedorAtual();
        System.out.println("Id vendedor = " + vendedor.getId() + " nome = "+ vendedor.getNome());
        VendaDAO venda= new VendaDAO();
        venda.save(vendaAtual);

        VendedorDAO daoV = new VendedorDAO();
        vendedor.addVenda(vendaAtual); //adicionando venda
        daoV.save(vendedor); //salvando no banco

        //s.setAttribute("vendedor-logado", vendedor); //Adicionando novamente a sessão

        //vendaAtual = new Venda();
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

    public LoginController getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(LoginController vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
    }

    
}
