package app.laEmpacadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class DetallePedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido_id")
    private Pedido id_pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_producto_id")
    private Producto id_producto;

    private Long cantidad;

    public DetallePedido(Pedido id_pedido, Producto id_producto, Long cantidad) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
}
