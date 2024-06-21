package app.laEmpacadora.repository;


import app.laEmpacadora.entity.DetallePedidoDom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetallePedidoDomRepository extends JpaRepository<DetallePedidoDom, Long> {
    Optional<DetallePedidoDom> findDetallePedidoDomById(Long id);

    @Query(value = "SELECT p.*, dp.cantidad AS cantidad, dp.observacion " +
            "FROM detalle_pedido_dom dp " +
            "JOIN producto p ON dp.id_producto_id = p.id " +
            "WHERE dp.id_domicilio_id = :domicilioId",
            nativeQuery = true)
    List<Object[]> findProductosByDomicilioId(@Param("domicilioId") Long domicilioId);

}