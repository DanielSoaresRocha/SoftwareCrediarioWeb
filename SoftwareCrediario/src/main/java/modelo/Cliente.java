
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_cliente")
    private int id;
   /* 
    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY, orphanRemoval=true, cascade = CascadeType.ALL)
        private List<Venda> vendas = new ArrayList<>();
	
	
	public void addVenda(Venda novaVenda){
		vendas.add(novaVenda);
		novaVenda.setCliente(this);
	}
	
	public void removeVenda(Venda removeVenda){
		vendas.remove(removeVenda);
		removeVenda.setCliente(null);
	}
    */
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
/*
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }*/

   

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
    
}
