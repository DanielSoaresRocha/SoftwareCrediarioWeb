package controle;

import dao.VendedorDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.application.FacesMessage;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Vendedor;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController {

    private Vendedor vendedorAtual;

    public LoginController() {
        vendedorAtual = new Vendedor();
    }

    public String autentica() {
        FacesContext context = FacesContext.getCurrentInstance();

        VendedorDAO dao = new VendedorDAO();
        List<Vendedor> vendedores = dao.listAll();

        for (Vendedor i : vendedores) {
            if (i.getNome().equals(vendedorAtual.getNome())) {
                if (i.getSenha().equals(vendedorAtual.getSenha())) {
                    ExternalContext ec = context.getExternalContext();
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("vendedor-logado", vendedorAtual);          
                    vendedorAtual = i;//Colocando o vendedor do banco no objeto atual
                    System.out.println("Id = "+ vendedorAtual.getId());
                    System.out.println("Vendedor Encontrado" +vendedorAtual.getNome());
                    return "/vendedor/cadastrar.xhtml";
                }
            }
        }
        
        System.out.println("Vendedor não encontrado");
        FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, mensagem);
        return null;
        
    }

    public Vendedor getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(Vendedor vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
    }

}
