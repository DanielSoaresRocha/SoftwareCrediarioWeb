package controle;

import dao.ClienteDAO;
import dao.VendaDAO;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "administrar")
@SessionScoped
public class AdministrarClienteController {

    private List<Cliente> listaClientes;
    private ClienteDAO dao;
    private Cliente clienteAtual;

    public AdministrarClienteController() {
        System.out.println("ENNNTTRROUUUUUUUUUUUUUUUUUUUUUUU");
        //clienteAtual = new Cliente();
        listaClientes = new ArrayList<>();
        
        //dao = new ClienteDAO();
        //listaClientes = dao.listAll();
    }

    public void listar() {
        System.out.println("-----------------------Listou----------------");
        listaClientes = new ArrayList<>();
        dao = new ClienteDAO();
        listaClientes = dao.listAll();
    }

    public String realizarVenda(Cliente c) {
        clienteAtual = new Cliente();
        clienteAtual = c;

        System.out.println("QUERENDO VENDER PARA: " + clienteAtual.getId());
        return "/vendedor/realizarVenda";

    }

    public String excluirCliente(Cliente c) {
        FacesContext context = FacesContext.getCurrentInstance();

        dao = new ClienteDAO();
        if (c.getVendas().isEmpty()) {
            System.out.println("O CLIENTE N TINHA VENDAS");
            dao.delete(c);

            FacesMessage mensagem = new FacesMessage("O cliente foi excluido com sucesso");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);

        } else {
            System.out.println("O CLIENTE TEM VENDAS");
            FacesMessage mensagem = new FacesMessage("O cliente possui vendas assossiadas, exclua a sua venda relacionada primeiro");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }

        //return null;
        return "/vendedor/Administrar.xhtml";
    }

    public String editarCliente(Cliente c) {
        clienteAtual = new Cliente();
        clienteAtual = c;
        System.out.println("QUETENDO SALVAR "+ clienteAtual.getId() + " nome = "+ clienteAtual.getNome());
        return "/vendedor/editarCliente.xhtml";
    }

    public String salvar() {
        
        dao = new ClienteDAO();
        System.out.println("SALVANDO "+ clienteAtual.getId() + " nome = "+ clienteAtual.getNome());
        dao.save(clienteAtual);
        System.out.println("cliente salvo id =" + clienteAtual.getId());

        return "/vendedor/Administrar.xhtml";
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
