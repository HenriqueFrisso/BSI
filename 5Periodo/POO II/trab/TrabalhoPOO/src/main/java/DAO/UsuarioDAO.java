package DAO;

import domain.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UsuarioDAO {

    public static void cadastrarUsuario(Usuario usuario) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            session.save(usuario);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    public static void removerUsuario(Long id) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }

    public static List<Usuario> listarUsuarios() {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            return session.createQuery("from Usuario", Usuario.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public static boolean verificarLogin(String email, String senha) {
        try (Session session = Conexao.getSessionFactory().openSession()) {
            String hql = "FROM usuario WHERE email = :email AND senha = :senha";
            List<Usuario> resultado = session.createQuery(hql, Usuario.class)
                                             .setParameter("email", email)
                                             .setParameter("senha", senha)
                                             .getResultList();
            return !resultado.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Usuario getUsuario(String email) {
    try (Session session = Conexao.getSessionFactory().openSession()) {
        String hql = "FROM usuario WHERE email = :email";
        return session.createQuery(hql, Usuario.class)
                      .setParameter("email", email)
                      .uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
