package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        try {
            this.entityManager.persist(cardapio);
        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por Valor. " + e.getMessage());

        }
    }

    public Cardapio consultaId(final Integer id) {
        try {
            Cardapio cardapio = this.entityManager.find(Cardapio.class, id);
            return cardapio;

        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por ID. " + e.getMessage());

            return null;
        }
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager
                    .createQuery(jpql, Cardapio.class)
                    .setParameter("valor", filtro)
                    .getResultList();

        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por Valor. " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public Cardapio consultarPorNome(final String filtro) {
        try {
            String jpql = "Select c From Cardapio c where UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager
                    .createQuery(jpql, Cardapio.class)
                    .setParameter("nome", filtro)
                    .getSingleResult();

        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por nome. " + e.getMessage());
            return null;
        }
    }

    public List<Cardapio> listar() {
        try {
            String jpql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();

        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por Valor. " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public void atualizar(Cardapio cardapio) {
        try {
            this.entityManager.merge(cardapio);
        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por Valor. " + e.getMessage());
        }
    }

    public void excluir(final Cardapio cardapio) {
        try{
        this.entityManager.remove(cardapio);
        } catch (RuntimeException e) {
            System.out.println();
            System.out.println("Falha ao consultar por Valor. " + e.getMessage());
        }
    }


}
