package Controller;

import DAO.MainDAO;
import com.mycompany.trabalhopoo.*;
import java.util.*;

public class Controller {
    
    private static Tipo tipoAtual = Tipo.USUARIO;
    
    public static void trocarTipoAtual(){
        if (tipoAtual == Tipo.USUARIO){
            tipoAtual = Tipo.LOJA;
        }else{
            tipoAtual = Tipo.USUARIO;
        }
    }
    public static Tipo getTipoAtual() {
        return tipoAtual;
    }
    public enum Tipo {
    USUARIO, LOJA;
    }
    private static String codigoRecuperacao;

    private static Usuario usuarioAtual = new Usuario("","","");
    private static Produto produtoAtual = new Produto("", 0);
    private static ArrayList<Produto> Produtos = MainDAO.carregarListaInicial();

    public static ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public static void setProdutos(ArrayList<Produto> Produtos) {
        Controller.Produtos = Produtos;
    }
    private static ArrayList<Produto> procurarProdutos = MainDAO.carregarListaInicial();
    private static ArrayList<Produto> carrinho = new ArrayList<>();
    private static ArrayList<Endereco> enderecos = MainDAO.carregarEnderecos();
    
    
    
    public static String getCodigoRecuperacao() {
        return codigoRecuperacao;
    }

    public static void setCodigoRecuperacao(String codigoRecuperacao) {
        Controller.codigoRecuperacao = codigoRecuperacao;
    }
    
    public static boolean verificarLogin(String usuario, String senha){
        if (tipoAtual == Tipo.USUARIO){
            
        }else{
            
        }
        return true;
    }
    
    
    public static ArrayList<Endereco> getEnderecos(){
        return removeDuplicados(enderecos);
    }
    public static void removerEndereco(ArrayList<Endereco> l, Endereco e){
        l.remove(e);
        enderecos = l; 
    }
    
    public static <T> ArrayList<T> removeDuplicados(ArrayList<T> list) {
    return new ArrayList<>(new LinkedHashSet<>(list));
}
    
    public static void limparCarrinho(){
        carrinho.clear();
    }
    public static void adicionarCarrinho(Produto p){
        Controller.carrinho.add(p);
    }
    public static ArrayList<Produto> getCarrinho(){
        return removeDuplicados(carrinho);
    }
    public static void removerProduto(ArrayList<Produto> l, Produto p){
        l.remove(p);
        carrinho = l; 
    }
    public static ArrayList<Produto> getProcurarProdutos() {
        return procurarProdutos;
    }
    public static Usuario getUsuario(){
        return usuarioAtual;
    }
    public static Produto getProduto(){
        return produtoAtual;
    }
    
    public static void setProcurarProdutos(ArrayList<Produto> procurarProdutos) {
        Controller.procurarProdutos = procurarProdutos;
    }
    public static void setUsuario(Usuario usuario){
        Controller.usuarioAtual = usuario;
    }
    public static void setProduto(Produto produto){
        Controller.produtoAtual = produto;
    }
    
}
