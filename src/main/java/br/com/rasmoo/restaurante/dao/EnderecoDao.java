package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {

    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Endereco endereco){
        this.entityManager.persist(endereco);
    }

    public Endereco consultar(final Integer id){
        Endereco endereco = this.entityManager.find(Endereco.class, id);
        return endereco;
    }

    public List<Endereco> listar(){
        String jpql = "SELECT c FROM Endereco c";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }
    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco){
        this.entityManager.remove(endereco);
    }

}
