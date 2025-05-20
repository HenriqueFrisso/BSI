
package com.mycompany.trabalhopoo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Entity(name="endereco")
@Data
@AllArgsConstructor
public class Endereco {
    String cep, estado, cidade, rua;
    int numero;

}
