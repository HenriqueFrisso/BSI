package com.mycompany.trabalhopoo;


import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Entity(name="loja")
@Data
@AllArgsConstructor
public class Loja {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String codigo;
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Endereco> endereco;
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Produto> produto;
    
    
    
}