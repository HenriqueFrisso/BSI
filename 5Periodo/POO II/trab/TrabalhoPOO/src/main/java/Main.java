

import DAO.Conexao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import viewer.Tela;

public class Main {

    public static void main(String[] args) {
        Tela tela = new Tela();
        try{
        SessionFactory con = Conexao.getSessionFactory();
        }catch(HibernateException ex){
            throw new RuntimeException(ex.getMessage());
        }
        tela.setVisible(true);
    }
}
