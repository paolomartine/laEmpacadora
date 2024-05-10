package app.laEmpacadora.entity;

import lombok.*;

@Getter
@NoArgsConstructor
public enum EnumEstado {
    EN_PREPARACION("EN_PREPARACION"),
    EN_DESPACHO("EN_DESPACHO"),
    CANCELADO("CANCELADO"),
    PAGADO("PAGADO"),
    DESPACHADO("DESPACHADO");

    private String estado;

    EnumEstado(String estado) {
        this.estado = estado;
    }
}
