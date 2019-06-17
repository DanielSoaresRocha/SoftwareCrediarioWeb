package modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "senhas")
public class Senha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id;
    
    @Column(name="senha")
    private String senha;
    
    @OneToOne(mappedBy="senha"/*, orphanRemoval=true*/)
    Vendedor vendedor;

    public Senha() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
