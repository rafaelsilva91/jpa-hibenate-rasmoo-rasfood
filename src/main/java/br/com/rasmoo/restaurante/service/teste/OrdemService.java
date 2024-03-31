package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.sql.Array;
import java.util.ArrayList;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);


        Endereco endereco = new Endereco("Bairro teste", "00000000");
        Cliente joao = new Cliente("00000000000", "Joao Silva");
        joao.addEndereco(endereco);
        Ordem ordem = new Ordem(joao);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultaId(1), 2 ));
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultaId(2), 6 ));
        clienteDao.cadastrar(joao);
        ordemDao.cadastrar(ordem);
        System.out.println("ORDENS CARDAPIO:\n"+ordem.getOrdensCardapioList());

        System.out.println();
        System.out.println(ordemDao.consultaritensMaisVendidos());

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
