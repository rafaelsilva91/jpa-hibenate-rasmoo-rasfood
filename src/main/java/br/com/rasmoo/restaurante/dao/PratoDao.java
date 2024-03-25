package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: "+prato);
    }

    public Prato consultar(final Integer id){
        Prato prato = this.entityManager.find(Prato.class, id);
        return prato;
    }
    public void atualizar(Prato prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Prato prato){
        this.entityManager.remove(prato);
    }

}
