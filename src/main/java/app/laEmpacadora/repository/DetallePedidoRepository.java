package app.laEmpacadora.repository;

import app.laEmpacadora.entity.DetallePedido;
import app.laEmpacadora.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    Optional<DetallePedido> findDetallePedidoById(Long id);
}