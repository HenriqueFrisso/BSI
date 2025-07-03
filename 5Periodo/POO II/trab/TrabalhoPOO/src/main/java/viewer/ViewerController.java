/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer;

import DAO.CarrinhoDAO;
import DAO.EnderecoDAO;
import DAO.LojaDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import controller.Controller;
import domain.Endereco;
import domain.Loja;
import domain.Produto;
import domain.ProdutoCarrinho;
import domain.ProdutoCarrinhoId;
import domain.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ViewerController {
    
    
    protected static Loja getLoja(){
        return Controller.getLoja();
    }
    
    
    protected static void cadastrarEndereco(Endereco e){
        if (Controller.getTipoAtual() == Controller.Tipo.LOJA){
            EnderecoDAO.adicionarEndereco(e, Controller.getLoja());
        } else{
            EnderecoDAO.adicionarEndereco(e, Controller.getUsuario());
        }
    }
    protected static void removerEndereco(Endereco endereco){
        EnderecoDAO.removerEndereco(endereco.getId());
        Controller.removerEndereco(Controller.getEnderecos(), endereco);
    }
        
        
    protected static void atualizarProdutos(){
        Controller.setProdutos(ProdutoDAO.listarProdutosPorLoja(Controller.getLoja().getId()));
    }
    
    protected static void cadastrarProduto(Produto produto){
        ProdutoDAO.cadastrarProduto(produto);
        Controller.adicionarProduto(produto);
    }
    protected static void removerProduto(Produto produto){
        ProdutoDAO.removerProduto(produto.getId());
        Controller.removerProduto(Controller.getProdutos(), produto);
    }

    protected static void atualizarProduto(String nome, double preco, byte[] imagemBytes, long id) {
        ProdutoDAO.atualizarProduto(nome, preco, imagemBytes, id);
    }
    
    
    protected static void atualizarLoja(String nome, String telefone, byte[] logo){
        LojaDAO.atualizarLoja(nome, telefone, logo, Controller.getLoja().getId());
    }
    
    protected static void setUsuario(String email){
        UsuarioDAO.getUsuario(email);
    }
    protected static void setLoja(String cnpj){
        LojaDAO.getLoja(cnpj);
    }

    protected static boolean verificarLogin(String usuario, String senha) {
        return Controller.verificarLogin(usuario, senha);
    }

    protected static void atualizarEndereco(String cep, String estado, String cidade, String rua, String numero, long id) {
        EnderecoDAO.atualizarEndereco(cep, estado, cidade, rua, numero, id);
    }

    protected static Produto getProduto() {
        return Controller.getProduto();
    }

    static void adicionarCarrinho(Produto produto, int qtd) {
        CarrinhoDAO.adicionarProdutoAoCarrinho(produto.getId(), ViewerController.getUsuario().getId(), qtd);
        Controller.adicionarCarrinho(produto);
    }

    static Usuario getUsuario() {
        Usuario u = Controller.getUsuario();
        return u;
    }
    static Usuario attUsuario(){
        Usuario u = UsuarioDAO.getUsuario(ViewerController.getUsuario().getId());
        if (u == null){return Controller.getUsuario();}
        return u;
    }
    
    static ArrayList<ProdutoCarrinho> getCarrinho(){
        return CarrinhoDAO.listarProdutosDeUsuario(ViewerController.getUsuario().getId());
    }

    static void atualizarProdutoCarrinho(ProdutoCarrinhoId fk, int qtd) {
        CarrinhoDAO.atualizarProdutoCarrinho(fk.getProduto().getId(), fk.getCarrinho().getId(), qtd);
    }

    static void removerProdutoCarrinho(ProdutoCarrinho p) {
        CarrinhoDAO.removerProdutoDoCarrinho(p.getFk().getProduto().getId(), p.getFk().getCarrinho().getUsuario().getId());
    }

    static void atualizarDados(String nome, String cpf, String email) {
        UsuarioDAO.alterarDados(ViewerController.getUsuario().getId(), nome, cpf, email);
    }
    static void atualizarSenha(String senhaAntiga, String senhaNova) {
        boolean sucesso = UsuarioDAO.alterarSenha(ViewerController.getUsuario().getEmail(), senhaAntiga, senhaNova);
        if (sucesso) {
        } else {
            JOptionPane.showMessageDialog(null, "Senha atual incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    static ArrayList<Produto> procurarProdutoPorNome(String nome){
        return ProdutoDAO.buscarProdutosPorNome(nome);
    }
}
