package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);

        System.out.println();
        System.out.println(cardapioDao.consultarPorValor(BigDecimal.valueOf(88.50)));

        System.out.println();
        System.out.println(cardapioDao.consultarPorNome("risoto"));

        System.out.println();
        System.out.println(cardapioDao.consultarPorNome("maria isabel"));

        entityManager.flush();
        entityManager.clear();

    }

//        System.out.println("==========================================================================");
//        System.out.println(cardapioDao.consultaId(1));
//        System.out.println("==========================================================================");
//        System.out.println(cardapioDao.consultaId(2));
//        System.out.println("==========================================================================");
//
//        System.out.println();
//        System.out.println("================================LISTAR TODOS==============================");
//        System.out.println(cardapioDao.listar());
//        System.out.println("==========================================================================");
//        cardapioDao.listar().forEach(elemento -> System.out.println("Consulta: "+elemento));
//        System.out.println("==========================================================================");
//
//        System.out.println();
//        System.out.println("================================LISTAR POR VALOR==========================");
//        cardapioDao.consultarPorValor(BigDecimal.valueOf(88.50))
//                .forEach(elemento -> System.out.println("Consulta por valor: "+elemento));
//        System.out.println("==========================================================================");
//    }
}
