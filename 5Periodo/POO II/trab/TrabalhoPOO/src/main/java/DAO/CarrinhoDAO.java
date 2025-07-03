/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.Carrinho;
import domain.Produto;
import domain.ProdutoCarrinho;
import domain.ProdutoCarrinhoId;
import domain.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Henrique
 */
public class CarrinhoDAO {
public static void adicionarProdutoAoCarrinho(Long produtoId, Long usuarioId, int qtd) {
    Transaction transacao = null;
    try (Session session = Conexao.getSessionFactory().openSession()) {
        transacao = session.beginTransaction();

        Usuario usuario = session.get(Usuario.class, usuarioId);
        Produto produto = session.get(Produto.class, produtoId);

        // Procurar carrinho do usuário
        Carrinho carrinho = session.createQuery(
            "from carrinho c where c.usuario.id = :usuarioId", Carrinho.class)
            .setParameter("usuarioId", usuarioId)
            .uniqueResult();

        // Se não existir, criar novo
        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.setUsuario(usuario);
            carrinho.setDataPedido(new Date());
            carrinho.setPrecoTotal(0);
            session.save(carrinho);
        }

        // Verificar se o produto já está no carrinho
        ProdutoCarrinhoId pk = new ProdutoCarrinhoId();
        pk.setProduto(produto);
        pk.setCarrinho(carrinho);
        
        ProdutoCarrinho produtoCarrinho = session.get(ProdutoCarrinho.class, pk);

        if (produtoCarrinho == null) {
            // Cria novo ProdutoCarrinho com a qtd passada
            produtoCarrinho = new ProdutoCarrinho();
            produtoCarrinho.setFk(pk);
            produtoCarrinho.setQtd(qtd);
            session.save(produtoCarrinho);
        } else {
            // Incrementa a quantidade existente pela qtd passada
            produtoCarrinho.setQtd(produtoCarrinho.getQtd() + qtd);
            session.update(produtoCarrinho);
        }

        // Atualiza preço total considerando a qtd adicionada
        double novoPreco = carrinho.getPrecoTotal() + (produto.getPreco() * qtd);
        carrinho.setPrecoTotal((int) novoPreco);
        session.update(carrinho);

        transacao.commit();
    } catch (Exception e) {
        if (transacao != null) transacao.rollback();
        e.printStackTrace();
    }
}
public static void removerProdutoDoCarrinho(Long produtoId, Long usuarioId) {
    Transaction transacao = null;
    try (Session session = Conexao.getSessionFactory().openSession()) {
        transacao = session.beginTransaction();

        Produto produto = session.get(Produto.class, produtoId);

        Carrinho carrinho = session.createQuery(
            "from carrinho c where c.usuario.id = :usuarioId", Carrinho.class)
            .setParameter("usuarioId", usuarioId)
            .uniqueResult();

        if (carrinho == null) {
            System.out.println("Carrinho não encontrado.");
            return;
        }

        ProdutoCarrinhoId pk = new ProdutoCarrinhoId(produto, carrinho);
        ProdutoCarrinho produtoCarrinho = session.get(ProdutoCarrinho.class, pk);

        if (produtoCarrinho != null) {
            // Calcula o valor a remover
            double valorRemovido = produto.getPreco() * produtoCarrinho.getQtd();

            // Remove completamente o item
            session.delete(produtoCarrinho);

            // Atualiza o preço total
            double novoPreco = carrinho.getPrecoTotal() - valorRemovido;
            carrinho.setPrecoTotal((int) novoPreco);
            session.update(carrinho);
        }

        transacao.commit();
    } catch (Exception e) {
        if (transacao != null) transacao.rollback();
        e.printStackTrace();
    }
}
    public static ArrayList<ProdutoCarrinho> listarCarrinho(Long carrinhoId) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "from produto_carrinho pc where pc.fk.carrinho.id = :carrinhoId";
            return (ArrayList<ProdutoCarrinho>) session.createQuery(hql, ProdutoCarrinho.class)
                                                       .setParameter("carrinhoId", carrinhoId)
                                                       .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<ProdutoCarrinho> listarProdutosDeUsuario(Long usuarioId) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "select pc from produto_carrinho pc where pc.fk.carrinho.usuario.id = :usuarioId";
            return (ArrayList<ProdutoCarrinho>) session
                .createQuery(hql, ProdutoCarrinho.class)
                .setParameter("usuarioId", usuarioId)
                .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void atualizarProdutoCarrinho(Long produtoId, Long carrinhoId, int novaQtd) {
    Transaction transacao = null;
    try (Session session = Conexao.getSessionFactory().openSession()) {
        transacao = session.beginTransaction();

        Produto produto = session.get(Produto.class, produtoId);
        Carrinho carrinho = session.get(Carrinho.class, carrinhoId);

        if (produto == null || carrinho == null) {
            System.out.println("Produto ou Carrinho não encontrado.");
            return;
        }

        ProdutoCarrinhoId pk = new ProdutoCarrinhoId(produto, carrinho);
        ProdutoCarrinho produtoCarrinho = session.get(ProdutoCarrinho.class, pk);

        if (produtoCarrinho != null) {
            int qtdAntiga = produtoCarrinho.getQtd();
            produtoCarrinho.setQtd(novaQtd);
            session.update(produtoCarrinho);

            // Atualiza o preço total do carrinho
            double precoAtual = carrinho.getPrecoTotal();
            double precoRemover = qtdAntiga * produto.getPreco();
            double precoAdicionar = novaQtd * produto.getPreco();
            carrinho.setPrecoTotal((int) (precoAtual - precoRemover + precoAdicionar));
            session.update(carrinho);
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }

        transacao.commit();
    } catch (Exception e) {
        if (transacao != null) transacao.rollback();
        e.printStackTrace();
    }
}
}
