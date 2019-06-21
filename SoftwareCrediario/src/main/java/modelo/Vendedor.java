package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vendedor")
    private int id;

    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "nome")
    private String nome;

    
    //@OneToOne
    /*(cascade = {CascadeType.ALL}, orphanRemoval = true)*/
    //@JoinColumn(name = "credencial_id")
    //private Credencial credencial;

    public Vendedor() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
