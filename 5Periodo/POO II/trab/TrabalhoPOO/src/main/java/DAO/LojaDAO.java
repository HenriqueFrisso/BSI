/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.Loja;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Henrique
 */
public class LojaDAO {
    public static void cadastrarLoja(Loja loja) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            session.save(loja);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    public static void removerLoja(Long id) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            Loja loja = session.get(Loja.class, id);
            if (loja != null) {
                session.delete(loja);
            }
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    public static List<Loja> listarLojas() {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            return session.createQuery("from Loja", Loja.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean verificarLogin(String cnpj, String codigo) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "FROM loja WHERE cnpj = :cnpj AND codigo = :codigo";
            List<Loja> resultado = session.createQuery(hql, Loja.class)
                                          .setParameter("cnpj", cnpj)
                                          .setParameter("codigo", codigo)
                                          .getResultList();
            return !resultado.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Loja getLoja(String cnpj) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "FROM loja WHERE cnpj = :cnpj";
            return session.createQuery(hql, Loja.class)
                          .setParameter("cnpj", cnpj)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Atualizar loja por ID
    public static void atualizarLoja(String nome, String telefone, byte[] logo, Long id) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();

            Loja loja = session.get(Loja.class, id);
            if (loja != null) {
                loja.setNome(nome);
                loja.setTelefone(telefone);
                loja.setLogo(logo);
                session.update(loja);
            }

            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }
}
