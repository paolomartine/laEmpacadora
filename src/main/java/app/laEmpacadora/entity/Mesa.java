package app.laEmpacadora.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Mesa {
    @Id
    private Long id;
    private Boolean disponibilidad;

}
