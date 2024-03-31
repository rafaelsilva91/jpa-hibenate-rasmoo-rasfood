package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public Cliente consultar(final Integer id){
        Cliente cliente = this.entityManager.find(Cliente.class, id);
        return cliente;
    }

    public List<Cliente> listar(){
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    }
    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente){
        this.entityManager.remove(cliente);
    }

}
