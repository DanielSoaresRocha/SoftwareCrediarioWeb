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
        System.out.println("CHEGOUUUUUUUUUUUUU");
        ClienteDAO daoCliente = new ClienteDAO(); //preparando dao cliente
        daoCliente.save(clienteAtual); //adiciona o cliente no banco
        
        VendedorDAO daoVendedor = new VendedorDAO(); //preparando dao vendedor
        Vendedor v = vendedorAtual.getVendedorAtual(); //pegar venderdor
        System.out.println("Id do vendedor atual ="+ v.getId());
        v.addCliente(clienteAtual); //adicionar este cliente no vendedor
        daoVendedor.save(v); //salvar vendedor
        
        
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
