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

public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente_id")
    private Cliente id_cliente;

    private EnumEstado estado;

    private boolean borrado;

    public Domicilio(Cliente id_cliente, EnumEstado estado, boolean borrado) {
        this.id_cliente = id_cliente;
        this.estado = estado;
        this.borrado = borrado;
    }
}
