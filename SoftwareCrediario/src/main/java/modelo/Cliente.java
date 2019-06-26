
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_cliente")
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy="cliente",orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Venda> vendas = new ArrayList<>();
	
	
	public void addVenda(Venda novaVenda){
		vendas.add(novaVenda);
		novaVenda.setCliente(this);
	}
	
	public void removeVenda(Venda removeVenda){
		vendas.remove(removeVenda);
		removeVenda.setCliente(null);
	}
    
    @Column(name= "nome")
    private String nome;
    
    @Column(name= "cpf")
    private String cpf;
    
    @Column(name= "endereco")
    private String endereco;
    
    @Column(name= "telefone")
    private int telefone;
    
    @Column(name= "informacoes")
    private String informacoes;


    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereco, int telefone, String informacoes) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.informacoes = informacoes;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.vendas);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.endereco);
        hash = 83 * hash + this.telefone;
        hash = 83 * hash + Objects.hashCode(this.informacoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.informacoes, other.informacoes)) {
            return false;
        }
        if (!Objects.equals(this.vendas, other.vendas)) {
            return false;
        }
        return true;
    }

    
    
}
