package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    public static void cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Salada");
        Categoria principal = new Categoria("Pratos Principais");

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        entityManager.clear();

    }

    public static void cadastrarProdutoCardapio(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.listar();

        System.out.println();
        System.out.println("================================LISTAR TODAS CATEGORIAS===================");
        System.out.println(categorias);
        System.out.println("==========================================================================");
        categorias.forEach(elemento -> System.out.println("Categoria: "+elemento));
        System.out.println("==========================================================================");


        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));

        Cardapio espagueti = new Cardapio("Spagetti", "Spaguetti ao molho de parmesão e Cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));

        Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa de banana e batata frita",
                true, BigDecimal.valueOf(59.90), categorias.get(2));

        Cardapio risoto = new Cardapio("Risoto", "Risoto acompanhado de lula, polvo e mariscos",
                true, BigDecimal.valueOf(88.50), categorias.get(2));

        Cardapio mariaIsabel = new Cardapio("Maria Isabel", "Arroz com carne de sol, banana frita, calabresa picada",
                true, BigDecimal.valueOf(88.50), categorias.get(2));


        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(espagueti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(mariaIsabel);

//        entityManager.getTransaction().commit();
        entityManager.flush();
        entityManager.clear();


    }

}
