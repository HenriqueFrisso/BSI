package DAO;

import domain.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static void alterarDados(Long id, String nome, String cpf, String email) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, id);  // busca pelo id

            if (usuario != null) {
                usuario.setNome(nome);
                usuario.setCpf(cpf);
                usuario.setEmail(email);  // atualiza o email também
                session.update(usuario);
            } else {
                System.out.println("Usuário com id " + id + " não encontrado.");
            }

            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
        }
    }
    public static boolean alterarSenha(String email, String senhaAtual, String novaSenha) {
        Transaction transacao = null;
        try (Session session = Conexao.getSessionFactory().openSession()) {
            transacao = session.beginTransaction();

            String hql = "FROM usuario WHERE email = :email AND senha = :senhaAtual";
            Usuario usuario = session.createQuery(hql, Usuario.class)
                                     .setParameter("email", email)
                                     .setParameter("senhaAtual", senhaAtual)
                                     .uniqueResult();

            if (usuario != null) {
                usuario.setSenha(novaSenha);
                session.update(usuario);
                transacao.commit();
                return true;
            } else {
                // Senha atual incorreta
                return false;
            }

        } catch (Exception e) {
            if (transacao != null) transacao.rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public static Usuario getUsuario(Long id) {
    try (Session session = Conexao.getSessionFactory().openSession()) {
        return session.get(Usuario.class, id);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
}
