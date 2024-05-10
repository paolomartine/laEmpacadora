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
    private LocalDateTime hora_preparacion;
    private LocalDateTime hora_entrega;
    private int tiempo_espera;

    public Pedido(Cliente id_cliente, Mesa id_mesa, EnumEstado estado, LocalDateTime hora_preparacion, LocalDateTime hora_entrega, int tiempo_espera) {
        this.id_cliente = id_cliente;
        this.id_mesa = id_mesa;
        this.estado = estado;
        this.hora_preparacion = hora_preparacion;
        this.hora_entrega = hora_entrega;
        this.tiempo_espera = tiempo_espera;
    }
}