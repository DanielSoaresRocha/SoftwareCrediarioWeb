package controle;

import dao.ClienteDAO;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "administrar")
public class AdministrarClienteController {
    private List<Cliente> listaClientes;
    private ClienteDAO dao;
    private Cliente clienteAtual = new Cliente();

    public AdministrarClienteController() {
        System.out.println("ENNNTTRROUUUUUUUUUUUUUUUUUUUUUUU");
        listaClientes = new ArrayList<>();
        //clienteAtual = new Cliente();
        
        dao = new ClienteDAO();
        listaClientes = dao.listAll();
        
        
    }    
    public String realizarVenda(Cliente c){
        clienteAtual = new Cliente();
        clienteAtual = c;
        System.out.println("QUERENDO VENDER PARA: "+ clienteAtual.getId());
        return "/vendedor/realizarVenda";
        
    }
    
    public String excluirCliente(Cliente c){
        dao.delete(c);
        
        return "/vendedor/Administrar.xhtml";
    }
    
    public String editarCliente(Cliente c){
        clienteAtual = c;
        return "/vendedor/editarCliente.xhtml";
    }
    public String salvar(){
        dao = new ClienteDAO();
        dao.save(clienteAtual);
        System.out.println("cliente salvo id ="+ clienteAtual.getId());
       
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
