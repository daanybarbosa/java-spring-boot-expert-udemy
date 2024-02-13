package estudos.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity //incluindo JPA
//@Table(name = "tb_cliente", schema = "vendas") //incluindo JPA - exemplo - caso o nome da tabela no BD seja diferente da classe
@Table( name = "cliente" ) //incluindo JPA
public class Cliente {

    @Id //defini o primary key dessa entidade
    @GeneratedValue(strategy = GenerationType.AUTO) //implementar o auto increment no banco de dados
    @Column(name = "id") //nome da coluna no banco de dados
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    public Cliente(){ };

    public Cliente(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome){
        this.nome = nome;
    }
}
