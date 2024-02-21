package estudos.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne //muitos ItensPedidos para um Pedido
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne //muitos ItensPedidos para um Produto
    @JoinColumn(name = "produtos_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

}
