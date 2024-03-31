package br.com.rasmoo.restaurante.entity;


import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private String cep;

    @ManyToOne
    private Cliente cliente;

    public Endereco(String nome, String cep) {
        this.nome = nome;
        this.cep = cep;
    }

    public Endereco() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
//                ", cliente=" + cliente +
                '}';
    }
}
