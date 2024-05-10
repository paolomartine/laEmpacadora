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
    private int tiempoPreparacion;
    private Long precio;
    private String ingredientes;

    public Producto(String nombre, String url, int tiempoPreparacion, Long precio, String ingredientes) {
        this.nombre = nombre;
        this.url = url;
        this.tiempoPreparacion = tiempoPreparacion;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }
}
