package controle;

import dao.ClienteDAO;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "administrar")
@RequestScoped
public class AdministrarClienteController {
    private List<Cliente> listaClientes;

    public AdministrarClienteController() {
        ClienteDAO dao = new ClienteDAO();
        listaClientes = dao.listAll();
        
    }    
    
    
    
    
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
}
