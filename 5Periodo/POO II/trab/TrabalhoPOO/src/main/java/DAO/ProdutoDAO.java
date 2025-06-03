/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.Produto;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 2023122760018
 */
public class ProdutoDAO {
    public static void cadastrarProduto(Produto produto) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            session.save(produto);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    // Remover produto por ID
    public static void removerProduto(Long id) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            Produto produto = session.get(Produto.class, id);
            if (produto != null) {
                session.delete(produto);
            }
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    // Listar todos os produtos
    public static ArrayList<Produto> listarProdutos() {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            return (ArrayList<Produto>) session.createQuery("from Produto", Produto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar produtos por nome (usando LIKE)
    public static ArrayList<Produto> buscarProdutosPorNome(String nome) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "FROM Produto WHERE nome LIKE :nome";
            return (ArrayList<Produto>) session.createQuery(hql, Produto.class)
                          .setParameter("nome", "%" + nome + "%")
                          .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar produto por ID
    public static Produto buscarProdutoPorId(Long id) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            return session.get(Produto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
