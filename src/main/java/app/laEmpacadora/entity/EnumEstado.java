package app.laEmpacadora.entity;

import lombok.*;

@Getter
@NoArgsConstructor
public enum EnumEstado {
    PEDIDO("EN_PREPARACION"),
    DESPACHADO("DESPACHADO"),
    PAGADO("PAGADO");
    private String estado;

    EnumEstado(String estado) {
        this.estado = estado;
    }
}
