package modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_Vendedor")
    private int id;
    
    @Column(name= "cpf")
    private int cpf;
    
    @Column(name= "nome")
    private String nome;
    
    @OneToOne /*(cascade = {CascadeType.ALL}, orphanRemoval = true)*/
    @JoinColumn(name="senha_id")
    private Senha senha;
    
    public Vendedor() {
    }

    public Vendedor(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;  
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
            
}
