package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.vo.ItensPrincipaisVo;
import br.com.rasmoo.restaurante.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
    }

    public Ordem consultar(final Integer id){
        Ordem ordem = this.entityManager.find(Ordem.class, id);
        return ordem;
    }

    public List<Ordem> listar(){
        String jpql = "SELECT c FROM Ordem c";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public List<ItensPrincipaisVo> consultaritensMaisVendidos(){
        /*
        String jpql = "SELECT c.nome, oc.quantidade FROM Ordem o" +
                "JOIN OrdensCardapio oc ON o.id = oc.cardapio.id" +
                "JOIN Cardapio c ON oc.cardapio.id = c.id";
         */

        String jpql = "SELECT new br.com.rasmoo.restaurante.vo.ItensPrincipaisVo(" +
                "c.nome, SUM(oc.quantidade)) FROM Ordem o " +
                "JOIN OrdensCardapio oc ON o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(jpql, ItensPrincipaisVo.class).getResultList();
    }
    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem){
        this.entityManager.remove(ordem);
    }

}
