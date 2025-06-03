/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.Endereco;
import domain.Loja;
import domain.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Henrique
 */
public class EnderecoDAO {
    // Adicionar endereço para um usuário
    public static void adicionarEndereco(Endereco endereco, Usuario usuario) {
        endereco.setUsuario(usuario);
        endereco.setLoja(null); // garante que não está associado a uma loja
        salvarEndereco(endereco);
    }

    // Adicionar endereço para uma loja
    public static void adicionarEndereco(Endereco endereco, Loja loja) {
        endereco.setLoja(loja);
        endereco.setUsuario(null); // garante que não está associado a um usuário
        salvarEndereco(endereco);
    }

    // Método interno que salva no banco
    private static void salvarEndereco(Endereco endereco) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            session.save(endereco);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    // Listar todos os endereços
    public static List<Endereco> listarEnderecos() {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            return session.createQuery("from Endereco", Endereco.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Remover endereço
    public static void removerEndereco(Long id) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            Endereco endereco = session.get(Endereco.class, id);
            if (endereco != null) {
                session.delete(endereco);
            }
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }
}
