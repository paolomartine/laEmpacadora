package app.laEmpacadora.repository;

import app.laEmpacadora.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    Optional<DetallePedido> findDetallePedidoById(Long id);
    /*Optional<DetallePedido> findByIdAndPedidoId(Long id, Long idPro);

    @Query(value = "SELECT p.*, dp.cantidad AS cantidad, dp.observacion, dp.estado_detalle " +
            "FROM detalle_pedido dp " +
            "JOIN producto p ON dp.id_producto_id = p.id " +
            "WHERE dp.id_pedido_id = :idPedido AND dp.id_producto_id = :idProducto",
            nativeQuery = true)
    List<Object[]> findProductosByPedidoIdYProductoId(@Param("idPedido") Long idPedido,
                                                      @Param("idProducto") Long idProducto);
*/



    @Query(value = "SELECT p.*, dp.cantidad AS cantidad, dp.observacion, dp.estado_detalle " +
            "FROM detalle_pedido dp " +
            "JOIN producto p ON dp.id_producto_id = p.id " +
            "WHERE dp.id_pedido_id = :pedidoId",
            nativeQuery = true)
    List<Object[]> findProductosByPedidoId(@Param("pedidoId") Long pedidoId);





}
