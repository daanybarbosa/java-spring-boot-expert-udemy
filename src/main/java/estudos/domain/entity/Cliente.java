package estudos.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

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

    /**
     * @OneToMany - um cliente para muitos pedidos
     * Por default o fetch é LAZY (preguiçoso), ou seja, determinados objetos não serão
     *  carregados do banco até que solicite explicidademente o carregamento deles, isso evita sobrecargar da aplicação com dados inuteis/não utilizados.
     * O fetch EAGER (ansioso), ou seja, carrega todos os dados mesmo sem utiliza-los.
     * */
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos; //pedidos não pode se repetir

    public Cliente(){ };

    public Cliente(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome){
        this.nome = nome;
    }
}
