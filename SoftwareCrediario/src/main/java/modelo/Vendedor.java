package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vendedor")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "vendedores_vendas", joinColumns = {
        @JoinColumn(name = "vendedor_id",
                referencedColumnName = "id_vendedor")}, inverseJoinColumns = {
        @JoinColumn(name = "venda_id")})
    private List<Venda> vendas = new ArrayList<>();

    public void addVenda(Venda nVenda) {
        vendas.add(nVenda);
        nVenda.getVendedores().add(this);
    }

    public void removeVenda(Venda nVenda) {
        vendas.remove(nVenda);
        nVenda.getVendedores().remove(this);
    }

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    public Vendedor() {
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
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
