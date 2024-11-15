package app.laEmpacadora.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente_id")
    private Cliente id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_mesa_id")
    private Mesa id_mesa;

    private EnumEstado estado;

    public Pedido(Cliente id_cliente, Mesa id_mesa, EnumEstado estado) {
        this.id_cliente = id_cliente;
        this.id_mesa = id_mesa;
        this.estado = estado;

    }
}