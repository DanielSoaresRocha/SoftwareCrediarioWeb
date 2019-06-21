package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credencial")
public class Credencial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @OneToOne//(mappedBy = "credencial"/*, orphanRemoval=true*/)
    @JoinColumn(name="vendedor_id")
    private Vendedor vendedor;

    public Credencial() {
    }

   

    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
