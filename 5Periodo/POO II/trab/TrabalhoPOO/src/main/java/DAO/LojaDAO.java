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
}
