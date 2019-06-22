package controle;

import dao.ClienteDAO;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "administrar")
@RequestScoped
public class AdministrarClienteController {
    private List<Cliente> listaClientes;
    private ClienteDAO dao;
    private Cliente clienteAtual;
    
    @ManagedProperty(value = "#{cadastrar}")
    private cadastrarClienteController selecionado;

    public AdministrarClienteController() {
        listaClientes = new ArrayList<>();
        
        dao = new ClienteDAO();
        listaClientes = dao.listAll();
        
        
    }    
    
    public String editarCliente(Cliente c){
        clienteAtual = new Cliente();
        clienteAtual = c;
        return "/vendedor/editarCliente.xhtml";
    }
    public String salvar(){
        dao.save(clienteAtual);
       
        return "/vendedor/Administrar.xhtml";
    }

    public cadastrarClienteController getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(cadastrarClienteController selecionado) {
        this.selecionado = selecionado;
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
