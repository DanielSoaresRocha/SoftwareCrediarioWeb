
package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Vendedor;

@ManagedBean(name="login")
@SessionScoped
public class LoginController {
    private Vendedor vendedorAtual;

    public LoginController() {
        vendedorAtual = new Vendedor();
    }
    
    public void autentica(){
        System.out.println("Nome =" + vendedorAtual.getNome());
        System.out.println("Senha =" + vendedorAtual.getSenha());
        
    }
    
    public Vendedor getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(Vendedor vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
    }
      
    
}
