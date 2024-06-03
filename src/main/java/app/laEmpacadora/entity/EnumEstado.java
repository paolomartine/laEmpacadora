package app.laEmpacadora.entity;

import lombok.*;

@Getter
@NoArgsConstructor
public enum EnumEstado {

    PEDIDO("PEDIDO"),
    DESPACHADO("DESPACHADO"),
    PAGADO("PAGADO");
    private String estado;

    EnumEstado(String estado) {
        this.estado = estado;
    }
}
