package controle;

import dao.CredencialDAO;
import dao.VendedorDAO;
import genericdao.impl.CredencialDaoImpl;
import genericdao.interfaces.ICredencialDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.application.FacesMessage;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.*;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController {

    private Vendedor vendedorAtual;
    private String login;
    private String senha;

    public LoginController() {
        vendedorAtual = new Vendedor();
    }

    public String autentica() {
        FacesContext context = FacesContext.getCurrentInstance();

        CredencialDAO dao = new CredencialDAO();
        List<Credencial> credenciais = dao.listAll();
        //ICredencialDao dao = new CredencialDaoImpl();

        for (Credencial i : credenciais) {
            if (i.getLogin().equals(login)) {
                if (i.getSenha().equals(senha)) {
                    ExternalContext ec = context.getExternalContext();
                    HttpSession s = (HttpSession) ec.getSession(true);
                    vendedorAtual = i.getVendedor();//Colocando o vendedor do banco no objeto atual
                    s.setAttribute("vendedor-logado", vendedorAtual);

                    System.out.println("Id = " + vendedorAtual.getId());
                    System.out.println("Vendedor Encontrado" + vendedorAtual.getNome());                   
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

    public String sair() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(true);
        s.invalidate();

        return "/index?faces-redirect=true";
    }

    public void criarVendedor() {
        //Adicionando credencial
        VendedorDAO daoV = new VendedorDAO();
        Vendedor v = new Vendedor();
        v.setNome("Daniel Soares Rocha");
        v.setCpf("3452345");
        daoV.save(v);

        Credencial c = new Credencial();
        c.setLogin("Daniel");
        c.setSenha("admin");
        c.setVendedor(v);

        CredencialDAO daoC = new CredencialDAO();
        daoC.save(c);

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Vendedor getVendedorAtual() {
        return vendedorAtual;
    }

    public void setVendedorAtual(Vendedor vendedorAtual) {
        this.vendedorAtual = vendedorAtual;
    }

}
