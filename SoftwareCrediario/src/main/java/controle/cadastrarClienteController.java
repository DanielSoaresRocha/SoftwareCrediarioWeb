package controle;

import javax.faces.bean.ManagedBean;

import modelo.Cliente;
import modelo.Vendedor;

import dao.ClienteDAO;
import dao.VendedorDAO;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;



@ManagedBean(name="cadastrar")
@RequestScoped
public class cadastrarClienteController {
    private Cliente clienteAtual;
    
    @ManagedProperty(value = "#{login}")
    private LoginController vendedorAtual;
    
    @ManagedProperty(value = "#{administrar}")
    private AdministrarClienteController lista;
    
    public cadastrarClienteController() {
        clienteAtual = new Cliente();
    }

    public void cadastrar(){
        lista.getListaClientes().add(clienteAtual);
        ClienteDAO daoCliente = new ClienteDAO(); //preparando dao cliente
        daoCliente.save(clienteAtual); //adiciona o cliente no banco               
        
        clienteAtual = new Cliente();
    }

    public AdministrarClienteController getLista() {
        return lista;
    }

    public void setLista(AdministrarClienteController lista) {
        this.lista = lista;
    }

    
    public LoginController getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(LoginController vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
    }
    
    
    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }
    
    
    
}
