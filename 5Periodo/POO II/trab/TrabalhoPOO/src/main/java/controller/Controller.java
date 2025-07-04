package controller;

import DAO.EnderecoDAO;
import DAO.LojaDAO;
import domain.Produto;
import domain.Endereco;
import domain.Usuario;
import DAO.MainDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import domain.Loja;
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
    
    private static Loja lojaAtual = new Loja();
    private static Usuario usuarioAtual = new Usuario();
    private static Produto produtoAtual = new Produto();
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    private static ArrayList<Produto> procurarProdutos = new ArrayList<Produto>();
    private static ArrayList<Produto> carrinho = new ArrayList<>();
    
    public static Loja getLoja(){
        return lojaAtual;
    }
    
    public static ArrayList<Produto> getProdutos() {
        return Controller.produtos;
    }

    public static void setProdutos(ArrayList<Produto> Produtos) {
        Controller.produtos = Produtos;
    }
    
    
    
    public static String getCodigoRecuperacao() {
        return codigoRecuperacao;
    }

    public static void setCodigoRecuperacao(String codigoRecuperacao) {
        Controller.codigoRecuperacao = codigoRecuperacao;
    }
    
    public static boolean verificarLogin(String usuario, String senha){
        boolean credenciais = verificarCredenciais(usuario, senha);
        if (credenciais){
            if (tipoAtual == Tipo.USUARIO){
                usuarioAtual = UsuarioDAO.getUsuario(usuario);
                lojaAtual = null;
            }else{
                lojaAtual = LojaDAO.getLoja(usuario);
                usuarioAtual = null;
            }
        }
        return credenciais;
    }
    public static boolean verificarCredenciais(String usuario, String senha){
        if (tipoAtual == Tipo.USUARIO){
            return (UsuarioDAO.verificarLogin(usuario, senha));
        }else{
            return (LojaDAO.verificarLogin(usuario, senha));
        }
    }
    
    
    public static ArrayList<Endereco> getEnderecos(){
        if (tipoAtual == Tipo.USUARIO){
            enderecos = EnderecoDAO.listarEnderecosPorUsuarioId(usuarioAtual.getId());
        }else{
            enderecos = EnderecoDAO.listarEnderecosPorLojaId(lojaAtual.getId());
        }
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
    
    public static void adicionarProduto(Produto p){
        Controller.produtos.add(p);
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
    
    public static void setProcurarProdutos() {
        Controller.procurarProdutos = ProdutoDAO.listarProdutos();
    }
    public static void setProcurarProdutos(ArrayList<Produto> p) {
        Controller.procurarProdutos = p;
    }
    public static void setUsuario(Usuario usuario){
        Controller.usuarioAtual = usuario;
    }
    public static void setLoja(Loja loja){
        Controller.lojaAtual = loja;
    }
    public static void setProduto(Produto produto){
        
        Controller.produtoAtual = produto;
    }
    
}
