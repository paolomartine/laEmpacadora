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
public class DetallePedidoDom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_domicilio_id")
    private Domicilio id_domicilio;

    @ManyToOne
    @JoinColumn(name = "id_producto_id")
    private Producto id_producto;

    private Long cantidad;

    public DetallePedidoDom(Domicilio id_domicilio, Producto id_producto, Long cantidad, String observacion) {
        this.id_domicilio = id_domicilio;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.observacion = observacion;
    }

    private String observacion;


}
