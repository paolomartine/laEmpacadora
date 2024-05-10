package app.laEmpacadora.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contacto;
    private String direccion;

    public Cliente(String nombre, String contacto, String direccion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }
}
