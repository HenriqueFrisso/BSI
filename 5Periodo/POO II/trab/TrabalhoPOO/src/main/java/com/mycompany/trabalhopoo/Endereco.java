
package com.mycompany.trabalhopoo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Entity(name="endereco")
@Data
@AllArgsConstructor
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cep;
    @Column
    private String estado;
    @Column
    private String cidade;
    @Column
    private String rua;
    @Column
    private int numero;

}
