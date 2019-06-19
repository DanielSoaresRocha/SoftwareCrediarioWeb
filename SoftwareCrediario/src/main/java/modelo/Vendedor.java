package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vendedor")
    private int id;

    @Column(name = "cpf")
    private int cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vendedor_cliente", joinColumns = {
        @JoinColumn(name = "vendedor_id",
                referencedColumnName = "id_Vendedor")}, inverseJoinColumns = {
        @JoinColumn(name = "cliente_id")})
    private List<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente nCliente) {
        clientes.add(nCliente);
        nCliente.getVendedores().add(this);
    }

    public void removeCliente(Cliente nCliente) {
        clientes.remove(nCliente);
        nCliente.getVendedores().remove(this);
    }

    public Vendedor() {
    }

    public Vendedor(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
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
