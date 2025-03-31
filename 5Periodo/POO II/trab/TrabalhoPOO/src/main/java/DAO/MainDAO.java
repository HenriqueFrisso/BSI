package DAO;

import com.mycompany.trabalhopoo.Endereco;
import com.mycompany.trabalhopoo.Loja;
import com.mycompany.trabalhopoo.Produto;
import com.mycompany.trabalhopoo.Usuario;
import java.util.ArrayList;

public class MainDAO {
    
    
    private static Usuario usuario = new Usuario("","","");
    private static Produto produto = new Produto("", 0);
    private static ArrayList<Produto> procurarProdutos = carregarListaInicial();
    private static ArrayList<Produto> carrinho = new ArrayList<>();
    
    public static Loja criarLoja(String nome, String cnpj, String codigo){
        Loja loja = new Loja(nome, cnpj, codigo);
        return loja;
    }
    public static Produto criarProduto(String nome, double preco){
        Produto p = new Produto(nome, preco);
        return p;
    }
    public static Endereco criarEndereco(String cep, String estado, String cidade, String rua, int num){
        Endereco endereco = new Endereco(cep, estado, cidade, rua, num);
        return endereco;
        
    }
    public static ArrayList<Produto> carregarListaInicial(){
        ArrayList<Produto> l = new ArrayList<>();
        
        l.add(criarProduto("Abacaxi", 5.10));
        l.add(criarProduto("Ameixa", 6.45));
        l.add(criarProduto("Banana", 3.70));
        l.add(criarProduto("Maça", 8.00));
        l.add(criarProduto("Pêssego", 12.50));
        return l;
    }
    
    public static ArrayList<Endereco> carregarEnderecos(){
        ArrayList<Endereco> l = new ArrayList<>();
        
        l.add(criarEndereco("297275010","MG","Marilândiaa","Av. Dom Bosco", 15));
        l.add(criarEndereco("297275000","ES","Marilândia","Alto Liberdade", 1));
        return l;
    }
}
