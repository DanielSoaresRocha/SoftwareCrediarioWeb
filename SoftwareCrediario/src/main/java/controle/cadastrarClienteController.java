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
    

    public cadastrarClienteController() {
        clienteAtual = new Cliente();
    }

    public void cadastrar(){
        ClienteDAO daoCliente = new ClienteDAO(); //preparando dao cliente
        daoCliente.save(clienteAtual); //adiciona o cliente no banco               
        
        clienteAtual = new Cliente();
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
