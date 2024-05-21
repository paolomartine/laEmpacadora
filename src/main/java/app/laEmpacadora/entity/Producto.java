package app.laEmpacadora.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;

    private String url;
    private Long precio;
    private String descripcion;

    public Producto(String nombre, String url, Long precio, String descripcion) {
        this.nombre = nombre;
        this.url = url;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
